package cn.wandingkeji.eurekaregistry.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * 解决eureka添加security权限验证导致服务无法注册到eureka上
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.user.name}")
    private String securityName;

    @Value("${spring.security.user.password}")
    private String securityPassword;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf访问
        http.csrf().disable();
    }


}
