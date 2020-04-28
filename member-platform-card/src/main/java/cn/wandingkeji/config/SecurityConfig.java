package cn.wandingkeji.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
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
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.user.name}")
    private String securityName;

    @Value("${spring.security.user.password}")
    private String securityPassword;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //对actuator监控所用的访问全部需要认证
        http.formLogin().and().authorizeRequests().antMatchers("/actuator/*").authenticated();
        //http.ignoring().antMatchers("/your_webpage_path/index.jsp");
        //http.antMatcher("/mini/card/*");

        //http.formLogin().and().authorizeRequests().antMatchers("/actuator/*").not();
    }

    @Bean
    public HttpHeaders getHeaders() { // 要进行一个Http头信息配置
        HttpHeaders headers = new HttpHeaders(); // 定义一个HTTP的头信息
        String auth = securityName + ":" + securityPassword; // 认证的原始信息
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        // 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        return headers;
    }

}
