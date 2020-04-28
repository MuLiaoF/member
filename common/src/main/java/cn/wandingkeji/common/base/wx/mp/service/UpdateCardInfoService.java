package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.UpdateCardReq;
import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.UpdateCardRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 更新会员卡信息接口
 * add by ws 0804
 */
public class UpdateCardInfoService extends BaseAPIService {
    private static final Logger log = LoggerFactory.getLogger(UpdateCardInfoService.class);

    public UpdateCardInfoService(String access_token) {
        super(WeiXinConstant.WX_UPDATE_CARD_INFO + access_token);
    }

    public UpdateCardRes request(UpdateCardReq updateCardReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(updateCardReq);
        log.info("==responseContent==" + responseString);
        UpdateCardRes updateCardRes = (UpdateCardRes) JSON.parseObject(responseString, UpdateCardRes.class);
        return updateCardRes;
    }


}
