package cn.wandingkeji.system.api;

import cn.wandingkeji.system.entity.PlatformBaseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("system")
public interface PlatformBaseApi {

    @PostMapping("/get/data")
    PlatformBaseData findByDataKey(@RequestParam("dataType") String dataType);

}
