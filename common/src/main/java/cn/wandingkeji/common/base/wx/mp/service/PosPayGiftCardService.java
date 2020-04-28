package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.DeliveryByPayReq;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;

/*
 * add by ws 0524
 * 支付即会员
 */
public class PosPayGiftCardService extends BaseAPIService {
    public PosPayGiftCardService(String access_token) {
        super(WeiXinConstant.WX_PAY_GIFT_CARD + access_token);
    }

    /**
     * 支付即会员服务
     *
     * @param CreatCardReq 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的JSON数据
     */
    public String request(DeliveryByPayReq deliveryByPayReq) {
        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(deliveryByPayReq);
        return responseString;
    }

}
