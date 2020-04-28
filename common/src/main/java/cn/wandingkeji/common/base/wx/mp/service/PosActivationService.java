package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.activation.ActivationMemCardReq;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;


/*
 * add by ws 0512
 * 接口激活
 */
public class PosActivationService extends BaseAPIService {

    public PosActivationService(String access_token) {
        super(WeiXinConstant.WX_ACTIVATION_CARD + access_token);
        // TODO Auto-generated constructor stub
    }

    /**
     * 激活会员卡
     *
     * @return API返回的JSON数据
     */
    public String request(ActivationMemCardReq activationMemCardReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(activationMemCardReq);

        return responseString;
    }

}
