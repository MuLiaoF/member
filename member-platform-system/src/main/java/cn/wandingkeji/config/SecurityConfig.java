package cn.wandingkeji.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //对actuator监控所用的访问全部需要认证
        http.formLogin().and().authorizeRequests().antMatchers("/actuator/*").authenticated();
        //http.ignoring().antMatchers("/your_webpage_path/index.jsp");
        http.antMatcher("/**");

        //http.formLogin().and().authorizeRequests().antMatchers("/actuator/*").not();
    }
}
