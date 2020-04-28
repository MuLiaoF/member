package cn.wandingkeji.common.base.wx.mp.service.open;

import cn.wandingkeji.common.base.wx.mp.protocol.open.GetAuthorizerInfoReq;
import cn.wandingkeji.common.base.wx.mp.protocol.open.GetAuthorizerInfoRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by fjr 0516
 * 获取授权方的帐号基本信息该API用于获取授权方的基本信息，包括头像、昵称、帐号类型、认证类型、微信号、原始ID和二维码图片URL。
 */
public class GetAuthorizerInfoService extends BaseAPIService {

	private static final Logger log = LoggerFactory.getLogger(GetAuthorizerInfoService.class);
	public GetAuthorizerInfoService(String access_token) {
		super(WeiXinConstant.GET_AUTHORIZER_INFO+access_token);
	}
	  /**
     * 
     *
     * @return API返回的JSON数据
     */
	  public GetAuthorizerInfoRes request(GetAuthorizerInfoReq authQueryReq) {

	        //--------------------------------------------------------------------
	        //发送HTTPS的Post请求到API地址
	        //--------------------------------------------------------------------
	        String responseString = sendPost(authQueryReq);
	        log.info("==responseContent=="+responseString);
	        GetAuthorizerInfoRes checkCodeRes = (GetAuthorizerInfoRes)  JSON.parseObject(responseString, GetAuthorizerInfoRes.class);
	        return checkCodeRes;
	    }

}
