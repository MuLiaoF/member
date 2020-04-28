package cn.wandingkeji.member.controller;


import cn.wandingkeji.member.entity.WdMember;
import cn.wandingkeji.member.service.IWdMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class WdMerberController {

    @Autowired
    private IWdMemberService memberService;

    @GetMapping("/info")
    WdMember findMemInfo(@RequestParam("mdCode") String mdCode) {
        return memberService.findMemInfo(mdCode);
    }

    @GetMapping("/opid")
    WdMember queryWdMember(@RequestParam("cardId")String cardId,@RequestParam("code") String code,@RequestParam("openId") String openId) {
        return memberService.queryWdMember(cardId, code, openId);
    }

    @PostMapping("/mid/condition")
    WdMember getMemberByMidAndCondition(@RequestParam Map<String, Object> whereCondition) {
        return memberService.getMemberByMidAndCondition(whereCondition);
    }
    @PostMapping("/openId")
    WdMember findMemIdByOpenId(@RequestParam("openId")String openId){
        return memberService.findMemIdByOpenId(openId);
    }

}
