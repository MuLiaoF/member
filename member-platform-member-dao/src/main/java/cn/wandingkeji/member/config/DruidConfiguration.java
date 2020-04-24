package cn.wandingkeji.member.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfiguration {

     @Value("${spring.datasource.driver-class-name}")
     private String jdbcDriver;
     @Value("${spring.datasource.url}")
     private String jdbcUrl;
     @Value("${spring.datasource.username}")
     private String jdbcUsername;
     @Value("${spring.datasource.password}")
     private String jdbcPassword;


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }
}