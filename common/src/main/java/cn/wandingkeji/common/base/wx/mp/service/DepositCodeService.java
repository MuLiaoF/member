package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.code.DepositCodeReq;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;


/*
 * add by fjr 0516
 * 导入code
 */
public class DepositCodeService extends BaseAPIService {

    public DepositCodeService(String access_token) {
        super(WeiXinConstant.WX_DEPOSIT_CODE + access_token);
    }

    /**
     * 导入code
     *
     * @return API返回的JSON数据
     */
    public String request(DepositCodeReq depositCodeReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(depositCodeReq);
//	        DepositCodeRes depositCodeRes = (DepositCodeRes)  JSON.parseObject(responseString, DepositCodeRes.class);
        return responseString;
    }

}
