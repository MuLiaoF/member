package cn.wandingkeji.member.controller;


import cn.wandingkeji.member.service.MermberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class MerberController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private MermberService mermberService;


    @GetMapping("/index")
    public String index() {
        return port  + "hello";
    }

    @GetMapping("/client")
    public String client() {
        return mermberService.index();
    }
}
