package cn.wandingkeji.common.base.wx.mp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * User: rizenguo
 * Date: 2014/12/10
 * Time: 15:44
 * 服务的基类
 */
public class BaseAPIService {

	private static final Logger log = LoggerFactory.getLogger(BaseAPIService.class);
    //API的地址
    private String apiURL;

    //发请求的HTTPS请求器
    private IServiceRequest serviceRequest;

    public BaseAPIService(String api) {
        try {
            apiURL = api;
          /*  Class c = Class.forName(Configure.HttpsRequestClassName);
            Constructor constructor = c.getDeclaredConstructor(new Class[]{WXPayConfigData.class});
            constructor.setAccessible(true);
            serviceRequest = (IServiceRequest) constructor.newInstance(new Object[]{spConfigData});*/
            serviceRequest = (IServiceRequest) new HttpsApiRequest();
        } catch (Exception e) {
            log.error(String.format("WXPay config error, api:%s", api), e);
            throw new ApiException(ExcepFactor.E_DEFAULT);
        }
    }


    protected String sendPost(Object xmlObj) {
        try {
//        	throw new SocketTimeoutException("read time out");
            return serviceRequest.sendPost(apiURL, xmlObj);
        } catch (Exception e) {
            log.error(String.format("WXPay sendPost error, api:%s", apiURL), e);
            if(e.getClass().getName().contains("NoHttpResponseException")){
            	throw new ApiException(ExcepFactor.E_REMOTE_ERROR,"NoHttpResponseException");
            }else if(e.getClass().getName().contains("SocketTimeoutException")){
            	throw new ApiException(ExcepFactor.E_REMOTE_ERROR,"SocketTimeoutException");
            }else{
            	throw new ApiException(ExcepFactor.E_REMOTE_ERROR);
            }
        }
    }

    /**
     * 供商户想自定义自己的HTTP请求器用
     *
     * @param request 实现了IserviceRequest接口的HttpsRequest
     */
    public void setServiceRequest(IServiceRequest request) {
        serviceRequest = request;
    }
}
