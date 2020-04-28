package cn.wandingkeji.common.http;

import cn.wandingkeji.common.enums.ErrorCode;
import cn.wandingkeji.common.system.config.exception.BussinessException;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


/**
 * @author fjr
 *
 */

public class PageRequestHelper {

	private static final Logger log = LoggerFactory.getLogger(PageRequestHelper.class);

	public PageRequestHelper() {}
	
	public static Map<String, Object> prasePageRequestContent(HttpServletRequest request) throws BussinessException{
		String requestContent = null;
		try {
			requestContent  = PayHelper.getStringByInputStream(request.getInputStream());
			log.error("===requestContent=" + requestContent);
			if (StringUtils.isEmpty(requestContent)) {
				log.error("报文发送内容为空！");
				throw new BussinessException(ErrorCode.DEFAULT_ERROR.getErrorCode()+"","报文发送内容为空");
			}
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new BussinessException(ErrorCode.DEFAULT_ERROR.getErrorCode()+"","流解析异常！");
		}
		Map<String, Object> requestJson = (Map<String, Object>)JSON.parseObject(requestContent,Map.class);
		return requestJson;
	}

	public static <T> T prasePageRequestContent(HttpServletRequest request,Class<T> clazz) throws BussinessException{
		String requestContent = null;
		try {
			requestContent  = PayHelper.getStringByInputStream(request.getInputStream());
			log.error("===requestContent=" + requestContent);
			if (StringUtils.isEmpty(requestContent)) {
				log.error("报文发送内容为空！");
				throw new BussinessException(ErrorCode.DEFAULT_ERROR.getErrorCode()+"","报文发送内容为空");
			}
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new BussinessException(ErrorCode.DEFAULT_ERROR.getErrorCode()+"","流解析异常！");
		}
		T requestJson = (T)JSON.parseObject(requestContent,clazz);
		return (T)requestJson;
	}

}
