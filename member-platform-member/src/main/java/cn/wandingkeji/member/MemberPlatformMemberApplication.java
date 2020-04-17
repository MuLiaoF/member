package cn.wandingkeji.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MemberPlatformMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberPlatformMemberApplication.class, args);
    }

}
