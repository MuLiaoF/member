package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetActiveInfoReq;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetActiveInfoRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by ws 20171214
 * 获取用户开卡时提交的信息（跳转型开卡组件）
 */
public class ActiveGetInfoService extends BaseAPIService {

    private static final Logger log = LoggerFactory.getLogger(ActiveGetInfoService.class);

    public ActiveGetInfoService(String access_token) {
        super(WeiXinConstant.GET_ACTIVE_INFO + access_token);
    }

    /**
     * @return API返回的JSON数据
     */
    public GetActiveInfoRes request(GetActiveInfoReq getActiveInfoReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(getActiveInfoReq);
        log.info("==responseContent==" + responseString);
        GetActiveInfoRes getInfoRes = (GetActiveInfoRes) JSON.parseObject(responseString, GetActiveInfoRes.class);
        return getInfoRes;
    }

}
