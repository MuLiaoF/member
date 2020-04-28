package cn.wandingkeji.token.controller;

import cn.wandingkeji.token.entity.AccessToken;
import cn.wandingkeji.token.entity.AccessTokenRes;
import cn.wandingkeji.token.service.IGetTokenUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@RestController("system")
public class TokenController {

    @Autowired
    private IGetTokenUtilService getTokenUtilService;
    @PostMapping("/get/token")
    public AccessTokenRes getToken(@RequestParam("mid") int mid, @RequestParam("tokenurl") String tokenUrl, @RequestParam("tokenType") int tokenType){
        AccessTokenRes token = getTokenUtilService.getToken(mid, tokenUrl, tokenType);
        return token;
    }
    @PostMapping("/get/token/typeAppid")
    public AccessToken getTokenByTypeAndAppid(@RequestParam("type")int type, @RequestParam("appid")String appid){
        return getTokenUtilService.getTokenByTypeAndAppid(type,appid);
    }

    @PostMapping("/get/token/tokenUrlAppid")
    public AccessToken getMiniSmallToken(@RequestParam("appid")String appid,@RequestParam("tokenUrl")String tokenUrl){
        return getTokenUtilService.getMiniSmallToken(appid, tokenUrl);
    }





}
