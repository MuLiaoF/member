package cn.wandingkeji.member.api;

import cn.wandingkeji.member.entity.WdMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@FeignClient("member")
public interface WdMemberApi {

    @GetMapping("/info")
    WdMember findMemInfo(@RequestParam("mdCode") String mdCode);

    @GetMapping("/opid")
    WdMember queryWdMember(@RequestParam("cardId")String cardId,@RequestParam("code") String code,@RequestParam("openId") String openId);

    @PostMapping("/mid/condition")
    WdMember getMemberByMidAndCondition(@RequestParam Map<String, Object> whereCondition);
    @PostMapping("/openId")
    WdMember findMemIdByOpenId(@RequestParam("openId")String openId);

}
