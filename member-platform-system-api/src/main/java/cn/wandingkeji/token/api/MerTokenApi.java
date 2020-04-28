package cn.wandingkeji.token.api;

import cn.wandingkeji.token.entity.MerToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@FeignClient("system")
public interface MerTokenApi {

    @PostMapping("/get/mer/token")
    MerToken getByMidAndType(@RequestParam("mid") int mid,@RequestParam("tokenType") String tokenType);

    @PostMapping("/add/mer/token")
    int add(@RequestBody MerToken merToken);

    /**
     * 根据主键id查询商户信息
     * @param tokenId
     * @param tokenType
     * @return MerToken
     */
    @PostMapping("/get/mer/token/idtokenType")
    MerToken getByTokenidAndType(@RequestParam("tokenId")int tokenId,@RequestParam("tokenType") String tokenType);

    @PostMapping("/get/mer/token/whereCondition")
    int selectTokenId(@RequestBody Map<String,Object> whereCondition);

}
