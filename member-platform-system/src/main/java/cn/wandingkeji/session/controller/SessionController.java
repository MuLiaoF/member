package cn.wandingkeji.session.controller;

import cn.wandingkeji.session.api.WxSessionApi;
import cn.wandingkeji.session.entity.WxSession;
import cn.wandingkeji.session.service.IWxSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@RestController
public class SessionController  {


    @Autowired
    private IWxSessionService wxSessionService;

    /**
     * 根据sessionid获取session对象
     *
     * @param record
     * @return
     */
    @PostMapping("/get/wxsession")
    public WxSession findBySession(Map<String, Object> record) {
        WxSession bySession = wxSessionService.findBySession(record);
        return bySession;
    }
    @PostMapping("/get/wxsession/condition")
    Map<String, Object> findWxSessionByMiniOpenId(Map<String, Object> condition){
        return wxSessionService.findWxSessionByMiniOpenId(condition);
    }



}
