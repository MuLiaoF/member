package cn.wandingkeji.common.base.wx.mp.business;


import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.CreatCouponRes;
import cn.wandingkeji.common.base.wx.mp.service.CreatCouponService;
import cn.wandingkeji.common.base.wx.mp.util.ApiException;
import cn.wandingkeji.common.base.wx.mp.util.Log;
import cn.wandingkeji.common.base.wx.mp.util.WXPayExcepFactor;
import com.alibaba.fastjson.JSON;

import java.util.Map;

public class CreatCouponBusiness {


    private String access_token;
    private CreatCouponService creatCouponService;

    private static Log log = new Log();

    public CreatCouponBusiness(String access_token) {

        this.access_token = access_token;
        creatCouponService = new CreatCouponService(access_token);


    }

    public CreatCouponRes run(Map<String, Object> card) {
        // 读取参数
        long costTimeStart = System.currentTimeMillis();
        String responseContent = creatCouponService.request(card);
        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        log.i("api请求总耗时：" + totalTimeCost + "ms");
        log.i("==responseContent==" + responseContent);

        CreatCouponRes scanCreatCouponResData = (CreatCouponRes) JSON.parseObject(responseContent, CreatCouponRes.class);
        if (scanCreatCouponResData == null || scanCreatCouponResData.getErrcode() == null) {
            log.e("【创建劵通知失败】创建劵通知请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_ERROR, "请检测数据是否规范合法");
        }

        if (!scanCreatCouponResData.getErrcode().equals("0")) {
            //注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.e("【创建劵通知失败】创建劵通知API系统返回失败，请检测Post给API的数据是否规范合法");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_FAIL, "请检测数据是否规范合法");
        } else {
            log.i("创建劵通知API系统成功返回数据");

        }
        return scanCreatCouponResData;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public CreatCouponService getCreatCouponService() {
        return creatCouponService;
    }

    public void setCreatCouponService(CreatCouponService creatCouponService) {
        this.creatCouponService = creatCouponService;
    }


}
