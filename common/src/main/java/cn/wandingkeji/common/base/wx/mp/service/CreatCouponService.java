package cn.wandingkeji.common.base.wx.mp.service;


import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;

import java.util.Map;


/*
 * add by ws 0603
 * 创建劵的service
 */
public class CreatCouponService extends BaseAPIService {

    public CreatCouponService(String access_token) {
        super(WeiXinConstant.WX_CREAT_CARD + access_token);
    }

    /**
     * 请求创建劵服务
     *
     * @param CreatCardReq 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的JSON数据
     */
    public String request(Map<String, Object> card) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(card);

        return responseString;
    }

}
