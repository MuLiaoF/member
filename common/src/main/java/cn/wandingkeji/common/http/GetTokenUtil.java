package cn.wandingkeji.common.http;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 获取token
 */
public class GetTokenUtil {

	private static final Logger log = LoggerFactory.getLogger(GetTokenUtil.class);
	public GetTokenUtil() {
		super();
	}
	  /**
     *
     * @return API返回的JSON数据
     */
	  public static <T> T  request(String url, Class<T> tClass) {

	        //--------------------------------------------------------------------
	        //发送HTTPS的Post请求到API地址
	        //--------------------------------------------------------------------
		  try {
//			  String tokenUrl = String.format(PayConstant.GET_TOKEN,tokenid);
		      String sendGetStr = PayHelper.sendGET(url);
		      log.info("==responseContent=="+sendGetStr);
		      T invoke = (T)  JSON.parseObject(sendGetStr, tClass);
		      return invoke;
		  }catch(Exception e) {
			  return null;
		  }
	    }
}
