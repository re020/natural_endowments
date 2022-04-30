package com.conf;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com")
@PropertySource("classpath:druid.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
public class SpringConfig {

}

