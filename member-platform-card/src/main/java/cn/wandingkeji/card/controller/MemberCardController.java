package cn.wandingkeji.card.controller;

import cn.wandingkeji.card.api.CardApi;
import cn.wandingkeji.card.entity.Card;
import cn.wandingkeji.card.entity.WdMemCard;
import cn.wandingkeji.service.card.IWdMemCardService;
import com.member.weixin.api.mp.protocol.activation.ActivationMemCardRes;
import com.member.weixin.api.mp.protocol.activation.GetUserInfoRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class MemberCardController {

    @Autowired
    private IWdMemCardService wdMemCardService;

    @PostMapping("/get/memCard")
    public WdMemCard getByWxCardId(@RequestParam("wxCardId") String wxCardId) {
        return wdMemCardService.selectByWxCardId(wxCardId);
    }

    @PostMapping("/activationCard")
    public ActivationMemCardRes activationCard(@RequestParam("cardId") String cardId,
                                               @RequestParam("code") String code,
                                               @RequestParam("memNum") String memNum,
                                               @RequestParam("token") String token) {
        return wdMemCardService.activationCard(cardId, code, memNum, token);
    }

    @PostMapping("/getUserInfo")
    public GetUserInfoRes getUserInfo(@RequestParam("cardId") String cardId,
                                      @RequestParam("code") String code,
                                      @RequestParam("token") String token) {
        return wdMemCardService.getUserInfo(cardId, code, token);
    }

}
