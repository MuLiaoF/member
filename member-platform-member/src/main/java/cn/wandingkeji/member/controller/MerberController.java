package cn.wandingkeji.member.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerberController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/index")
    public String index() {
        return port  + "hello";
    }


}
