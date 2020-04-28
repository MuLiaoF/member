package cn.wandingkeji.session.api;

import cn.wandingkeji.session.entity.WxSession;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@FeignClient("system")
public interface WxSessionApi {

    /**
     * 根据sessionid获取session对象
     *
     * @param record
     * @return
     */
    @PostMapping("/get/wxsession")
    WxSession findBySession(Map<String, Object> record);
    @PostMapping("/get/wxsession/condition")
    Map<String, Object> findWxSessionByMiniOpenId(Map<String, Object> condition);
}
