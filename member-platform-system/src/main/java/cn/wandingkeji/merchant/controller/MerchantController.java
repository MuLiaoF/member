package cn.wandingkeji.merchant.controller;

import cn.wandingkeji.merchant.entity.Merchants;
import cn.wandingkeji.merchant.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
public class MerchantController {

    @Autowired
    private IMerchantService merchantService;
    @PostMapping("/get/mid/merchants")
    public  Merchants selectById(@RequestParam("mid") int mid){
        return merchantService.selectById(mid);
    }
    /**
     * 更新商户信息
     * @param merchants
     * @return
     */
    @PostMapping("/update/mid/merchants")
    public  int updateById(@RequestBody Merchants merchants){
        return merchantService.updateById(merchants);
    }
    @PutMapping("/add/mid/merchants")
    public  int insert(@RequestBody Merchants record){
        return  merchantService.insert(record);
    }
    @PostMapping("/get/thridMid/merchants")
    public  Merchants selectByThridMid(@RequestParam("mid")Integer mid){
        return merchantService.selectByThridMid(mid);
    }


}
