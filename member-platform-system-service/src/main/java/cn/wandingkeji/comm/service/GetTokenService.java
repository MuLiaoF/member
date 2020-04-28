package cn.wandingkeji.comm.service;

import cn.wandingkeji.common.http.PayHelper;
import cn.wandingkeji.token.entity.AccessTokenRes;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 获取token
 */
public class GetTokenService {

	private static final Logger log = LoggerFactory.getLogger(GetTokenService.class);
	public GetTokenService() {
		super();
	}
	  /**
     *
     * @return API返回的JSON数据
     */
	  public AccessTokenRes request(String url) {
	        //--------------------------------------------------------------------
	        //发送HTTPS的Post请求到API地址
	        //--------------------------------------------------------------------
		  try {
		      String sendGetStr = PayHelper.sendGET(url);
		      log.info("==responseContent=="+sendGetStr);
		      AccessTokenRes accessToken = (AccessTokenRes)  JSON.parseObject(sendGetStr, AccessTokenRes.class);
		      return accessToken;
		  }catch(Exception e) {
			  return null;
		  }
	    }
}
