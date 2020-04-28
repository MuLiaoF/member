package cn.wandingkeji.store.controller;

import cn.wandingkeji.store.entity.Store;
import cn.wandingkeji.store.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@RestController
public class StoreController {

    @Autowired
    private IStoreService storeServiceI;


   @GetMapping("/get/store/id")
    public Store selectById(int id) {
        // TODO Auto-generated method stub
        return storeServiceI.selectById(id);
    }


}
