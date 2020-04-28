package cn.wandingkeji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@MapperScan("cn.wandingkeji.*.mapper")
@SpringBootApplication(scanBasePackages = {"cn.wandingkeji.*"})
public class MemberPlatformSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberPlatformSystemApplication.class, args);
    }

}
