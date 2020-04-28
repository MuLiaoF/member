package cn.wandingkeji.store.api;

import cn.wandingkeji.store.entity.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@FeignClient("system")
public interface StoreApi {

    @GetMapping("/get/store/id")
    Store selectById(@RequestParam("id") int id);

}
