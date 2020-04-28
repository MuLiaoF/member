package cn.wandingkeji.common.base.wx.mp.service.open;

import cn.wandingkeji.common.base.wx.mp.protocol.open.GetComponentTokenReq;
import cn.wandingkeji.common.base.wx.mp.protocol.open.GetComponentTokenRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by fjr 0516
 * 第三方平台component_access_token是第三方平台的下文中接口的调用凭据，
 */
public class GetComponentTokenService extends BaseAPIService {

    private static final Logger log = LoggerFactory.getLogger(GetComponentTokenService.class);

    public GetComponentTokenService() {
        super(WeiXinConstant.API_COMPONENT_TOKEN);
    }

    /**
     * @return API返回的JSON数据
     */
    public GetComponentTokenRes request(GetComponentTokenReq authQueryReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(authQueryReq);
        log.info("==responseContent==" + responseString);
        GetComponentTokenRes checkCodeRes = (GetComponentTokenRes) JSON.parseObject(responseString, GetComponentTokenRes.class);
        return checkCodeRes;
    }

}
