package cn.wandingkeji.merchant.api;

import cn.wandingkeji.merchant.entity.Merchants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@FeignClient("system")
public interface MerchantApi {

    @PostMapping("/get/mid/merchants")
    Merchants selectById(@RequestParam("mid") int mid);
    /**
     * 更新商户信息
     * @param merchants
     * @return
     */
    @PostMapping("/update/mid/merchants")
    int updateById(@RequestBody Merchants merchants);
    @PutMapping("/add/mid/merchants")
    int insert(@RequestBody Merchants record);
    @PostMapping("/get/thridMid/merchants")
    Merchants selectByThridMid(@RequestParam("mid")Integer mid);

}
