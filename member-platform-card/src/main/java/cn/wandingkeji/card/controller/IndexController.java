package cn.wandingkeji.card.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.wandingkeji.card.api.CardApi;


@RestController
public class IndexController implements CardApi {


    @Value("${server.port}")
    private Integer port;

    @GetMapping("/index")
    public String index() {
        return port  + "hello";
    }


}
