package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.DeleteCardReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.ResBaseData;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 删除会员卡service
 */
public class PosDeleteCardService extends BaseAPIService {
    private static final Logger log = LoggerFactory.getLogger(PosDeleteCardService.class);

    public PosDeleteCardService(String access_token) {

        super(WeiXinConstant.WX_DELETE_CARD + access_token);
    }

    public ResBaseData request(DeleteCardReq deleteCardReq) {
        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(deleteCardReq);
        log.info("==responseContent==" + responseString);
        ResBaseData baseDateRes = (ResBaseData) JSON.parseObject(responseString, ResBaseData.class);
        return baseDateRes;
    }
}
