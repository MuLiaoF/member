package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.createQrCard.CreatQrCardReq;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;


/*
 * add by fjr 0516
 * 获取发卡二维码接口
 */
public class PosCreatQrService extends BaseAPIService {

    public PosCreatQrService(String access_token) {
        super(WeiXinConstant.WX_CREATE_QRCODE + access_token);
        // TODO Auto-generated constructor stub
    }

    /**
     * 获取发卡二维码接口
     *
     * @return API返回的JSON数据
     */
    public String request(CreatQrCardReq creatQrCardReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(creatQrCardReq);

        return responseString;
    }

}
