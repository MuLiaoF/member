package cn.wandingkeji.coupon.api;

import cn.wandingkeji.coupon.entity.WdBindCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@FeignClient("card")
public interface WdBindCodeApi {

    @PostMapping("/get/id")
    WdBindCode getById(@RequestParam("id") int id);

    @PostMapping("/get/MdCode")
    WdBindCode getByMdCode(@RequestParam("id") String mdCode);

    @PostMapping("/add/id")
    int add(@RequestBody WdBindCode bindCode);

    @PostMapping("/put/id")
    int putById(@RequestBody WdBindCode bindCode);

    @PostMapping("/del/MdCode")
    void delByMdCode(@RequestParam("mdCode") String mdCode);

}
