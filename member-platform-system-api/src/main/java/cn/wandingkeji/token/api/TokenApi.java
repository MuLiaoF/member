package cn.wandingkeji.token.api;

import cn.wandingkeji.token.entity.AccessToken;
import cn.wandingkeji.token.entity.AccessTokenRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("system")
public interface TokenApi {

    @PostMapping("/get/token")
    public AccessTokenRes getToken(@RequestParam("mid") int mid, @RequestParam("tokenurl") String tokenUrl, @RequestParam("tokenType") int tokenType);
    @PostMapping("/get/token/typeAppid")
    public AccessToken getTokenByTypeAndAppid(@RequestParam("type")int type, @RequestParam("appid")String appid);
    @PostMapping("/get/token/tokenUrlAppid")
    public AccessToken getMiniSmallToken(@RequestParam("appid")String appid,@RequestParam("tokenUrl")String tokenUrl);


}
