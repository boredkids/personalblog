package pers.zhao.personalblog.bloggateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 引入外部配置
 */
@Configuration
@PropertySource("classpath:config/database.properties")
public class FileConfig {
}
