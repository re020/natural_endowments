package com.conf;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com")
@PropertySource("classpath:druid.properties")
public class JdbcConfig {
        @Value("${jdbc.driver}")
        private String diverClass;
        @Value("${jdbc.url}")
        private String url;
        @Value("${jdbc.username}")
        private String username;
        @Value("${jdbc.password}")
        private String password;
        @Bean
        public DataSource getDataSource(){
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setDriverClassName(diverClass);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        }

}
