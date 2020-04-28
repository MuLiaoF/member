package cn.wandingkeji.system.controller;

import cn.wandingkeji.system.entity.PlatformBaseData;
import cn.wandingkeji.system.service.IPlatformBaseDataService;
import cn.wandingkeji.system.service.impl.PlatformBaseDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@RestController
public class PlatformBaseController {


    @Autowired
    private IPlatformBaseDataService platformBaseDataService;


    @PostMapping("/get/data")
    public PlatformBaseData findByDataKey(@RequestParam("dataType") String dataType) {
        return platformBaseDataService.findByDataKey(dataType);
    }



}
