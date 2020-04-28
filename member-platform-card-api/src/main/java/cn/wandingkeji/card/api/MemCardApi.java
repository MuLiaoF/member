package cn.wandingkeji.card.api;

import cn.wandingkeji.card.entity.WdMemCard;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.ActivationMemCardRes;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUserInfoRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("card")
public interface MemCardApi {

    @PostMapping("/get/memCard")
    WdMemCard getByWxCardId(@RequestParam("wxCardId") String wxCardId);

    @PostMapping("/activationCard")
    ActivationMemCardRes activationCard(@RequestParam("cardId")String cardId,
                                        @RequestParam("code")String code,
                                        @RequestParam("memNum")String memNum,
                                        @RequestParam("token")String token);

    @PostMapping("/getUserInfo")
    GetUserInfoRes getUserInfo(@RequestParam("cardId") String cardId,
                               @RequestParam("code") String code,
                               @RequestParam("token") String token);
}
