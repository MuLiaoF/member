package cn.wandingkeji.coupon.controller;

import cn.wandingkeji.coupon.entity.WdBindCode;
import cn.wandingkeji.service.coupon.IWdBindCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@RestController
public class WdBindCodeController {

    @Autowired
    private IWdBindCodeService wdBindCodeService;

    @PostMapping("/get/id")
    public WdBindCode getById(@RequestParam("id") int id) {
        return wdBindCodeService.selectById(id);
    }

    @PostMapping("/get/MdCode")
    public WdBindCode getByMdCode(@RequestParam("id") String mdCode) {
        return wdBindCodeService.selectByMdCode(mdCode);
    }

    @PostMapping("/add/id")
    public int add(@RequestBody WdBindCode bindCode) {
        return wdBindCodeService.insert(bindCode);
    }

    @PostMapping("/put/id")
    public int putById(@RequestBody WdBindCode bindCode) {
        return wdBindCodeService.updateById(bindCode);
    }

    @PostMapping("/del/MdCode")
    public void delByMdCode(@RequestParam("mdCode") String mdCode){
        wdBindCodeService.deleteByMdCode(mdCode);
    }


}
