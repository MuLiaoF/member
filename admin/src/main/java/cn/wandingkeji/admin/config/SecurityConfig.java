package cn.wandingkeji.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.user.name}")
    private String securityName;

    @Value("${spring.security.user.password}")
    private String securityPassword;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //对actuator监控所用的访问全部需要认证
        //http.formLogin().and().authorizeRequests().antMatchers("/actuator/*").authenticated();
        //http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }




}
