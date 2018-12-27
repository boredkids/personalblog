package pers.zhao.personalblog.bloggateway.config;

import com.jarvis.cache.ICacheManager;
import com.jarvis.cache.redis.AbstractRedisCacheManager;
import com.jarvis.cache.redis.JedisClusterCacheManager;
import com.jarvis.cache.redis.SpringRedisCacheManager;
import com.jarvis.cache.script.AbstractScriptParser;
import com.jarvis.cache.script.SpringELParser;
import com.jarvis.cache.serializer.HessianSerializer;
import com.jarvis.cache.serializer.ISerializer;
import com.jarvis.cache.serializer.JdkSerializer;
import com.jarvis.cache.serializer.KryoSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.util.ClassUtils;
import redis.clients.jedis.JedisCluster;

/**
 * @author zhao
 * @date 2018/12/26 14:00
 */
@Slf4j
@Configuration
@ConditionalOnClass(name = "com.jarvis.cache.ICacheManager")
@EnableConfigurationProperties(AutoloadCacheProperties.class)
@AutoConfigureAfter(RedisAutoConfiguration.class)
@ConditionalOnProperty(value = "autoload.cache.enable", matchIfMissing = true)
public class AutoloadCacheManageConfiguration {

    private static final boolean hessianPresent = ClassUtils.isPresent(
            "com.caucho.hessian.io.AbstractSerializerFactory", AutoloadCacheManageConfiguration.class.getClassLoader());

    private static final boolean kryoPresent = ClassUtils.isPresent(
            "com.esotericsoftware.kryo.Kryo", AutoloadCacheManageConfiguration.class.getClassLoader());

    /**
     * 表达式解析器{@link AbstractScriptParser AbstractScriptParser} 注入规则：<br>
     * 如果导入了Ognl的jar包，优先 使用Ognl表达式：{@link OgnlParser
     * OgnlParser}，否则使用{@link SpringELParser SpringELParser}<br>
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(AbstractScriptParser.class)
    public AbstractScriptParser autoloadCacheScriptParser() {
        return new SpringELParser();
    }

    /**
     * * 序列化工具{@link ISerializer ISerializer} 注入规则：<br>
     * 如果导入了Hessian的jar包，优先使用Hessian：{@link HessianSerializer
     * HessianSerializer},否则使用{@link JdkSerializer JdkSerializer}<br>
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(ISerializer.class)
    public ISerializer<Object> autoloadCacheSerializer() {
        ISerializer<Object> res;
        // 推荐优先使用：Hessian
        if (hessianPresent) {
            res = new HessianSerializer();
            log.debug("HessianSerializer auto-configured");
        } else if (kryoPresent) {
            res = new KryoSerializer();
            log.debug("KryoSerializer auto-configured");
        } else {
            res = new JdkSerializer();
            log.debug("JdkSerializer auto-configured");
        }
        return res;
    }

    /**
     * 默认只支持{@link JedisClusterCacheManager JedisClusterCacheManager}<br>
     *
     * @param config
     * @param serializer
     * @param applicationContext
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(ICacheManager.class)
    @ConditionalOnClass(name = "org.springframework.data.redis.connection.RedisConnectionFactory")
    public ICacheManager autoloadCacheCacheManager(AutoloadCacheProperties config, ISerializer<Object> serializer,
                                                   ApplicationContext applicationContext) {
        return createRedisCacheManager(config, serializer, applicationContext);
    }

    public static ICacheManager createRedisCacheManager(AutoloadCacheProperties config, ISerializer<Object> serializer, ApplicationContext applicationContext) {
        RedisConnectionFactory connectionFactory = null;
        try {
            connectionFactory = applicationContext.getBean(RedisConnectionFactory.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        if (null == connectionFactory) {
            return null;
        }

        RedisConnection redisConnection = null;
        try {
            redisConnection = connectionFactory.getConnection();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }
        AbstractRedisCacheManager cacheManager;
        if (redisConnection instanceof JedisClusterConnection) {
            JedisClusterConnection redisClusterConnection = (JedisClusterConnection) redisConnection;
            // 优先使用JedisCluster; 因为JedisClusterConnection 批量处理，需要使用JedisCluster
            JedisCluster jedisCluster = redisClusterConnection.getNativeConnection();
            cacheManager = new JedisClusterCacheManager(jedisCluster, serializer);
        } else {
            cacheManager = new SpringRedisCacheManager(connectionFactory, serializer);
        }
        // 根据需要自行配置
        cacheManager.setHashExpire(config.getJedis().getHashExpire());
        return cacheManager;
    }
}

