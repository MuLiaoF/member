package cn.wandingkeji.card;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("cn.wandingkeji.mapper.*")
@SpringBootApplication(scanBasePackages = {"cn.wandingkeji.*"})
public class MerberPlatformCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MerberPlatformCardApplication.class, args);
    }

}
