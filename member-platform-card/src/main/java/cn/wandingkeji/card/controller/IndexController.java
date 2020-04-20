package cn.wandingkeji.card.controller;

import cn.wandingkeji.card.entity.Card;
import cn.wandingkeji.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wandingkeji.card.api.CardApi;


@RestController
public class IndexController implements CardApi {


    @Value("${server.port}")
    private Integer port;

    @Autowired
    private CardService cardService;

    @GetMapping("/index")
    @Override
    public String index() {
        return port  + "hello";
    }


    @GetMapping("/get/card")
    @Override
    public Card getCard(@RequestParam("id") String id) {
        return cardService.getCard(id);
    }



}
