package cn.wandingkeji.card.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


public interface CardApi {

    @GetMapping("/index")
    public String index();
}
