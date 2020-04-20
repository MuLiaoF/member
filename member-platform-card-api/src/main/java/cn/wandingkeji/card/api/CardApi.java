package cn.wandingkeji.card.api;

import cn.wandingkeji.card.entity.Card;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface CardApi {

    @GetMapping("/index")
    public String index();

    @GetMapping("/get/card")
    public Card getCard(@RequestParam("id") String id);
}
