package pers.zhao.personalblog.bloggateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 引入外部配置
 */
@Configuration
@PropertySources({@PropertySource("classpath:config/database.properties"),
        @PropertySource("classpath:config/redis.properties")})
public class FileConfig {
}
