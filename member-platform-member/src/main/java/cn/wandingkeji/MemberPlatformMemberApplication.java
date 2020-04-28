package cn.wandingkeji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("cn.wandingkeji.mapper.*")
@SpringBootApplication(scanBasePackages = {"cn.wandingkeji.*"})
public class MemberPlatformMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberPlatformMemberApplication.class, args);
    }

}
