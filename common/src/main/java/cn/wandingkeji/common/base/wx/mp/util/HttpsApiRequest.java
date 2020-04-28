package cn.wandingkeji.common.base.wx.mp.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;


public class HttpsApiRequest implements IServiceRequest {

    public interface ResultListener {

        public void onConnectionPoolTimeoutError();

    }

    private static Log log = new Log();

    //表示请求器是否已经做了初始化工作
    private boolean hasInit = false;

    //传输超时时间，默认10秒
    private int socketTimeout = 40000;

    //连接超时时间，默认30秒
    private int connectTimeout = 30000;

    //请求器的配置
    private RequestConfig requestConfig;

    //HTTP请求器
    private CloseableHttpClient httpClient;
    
    //服务商配置
//    public WXPayConfigData spConfigData;

    public HttpsApiRequest() throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
//    	this.spConfigData = spConfigData;
        init();
    }

    private void init() throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {
/*
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File(spConfigData.getCertLocalPath()));//加载本地的证书进行https加密传输
        try {
            keyStore.load(instream, spConfigData.getCertPassword().toCharArray());//设置证书密码
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, spConfigData.getCertPassword().toCharArray())
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[]{"TLSv1"},
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);*/

        
        httpClient = HttpClients.custom()
//                .setSSLSocketFactory(sslsf)
                .build();


        //根据默认超时限制初始化requestConfig
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();

        hasInit = true;
    }

    /**
     * 通过Https往API post xml数据
     *
     * @param url    API地址
     * @param xmlObj 要提交的XML数据对象
     * @return API回包的实际数据
     */
    @Override
    public String sendPost(String url, Object xmlObj) throws Exception {

        if (!hasInit) {
            init();
        }

        String result = null;

        HttpPost httpPost = new HttpPost(url);
/*
        //解决XStream对出现双下划线的bug
        XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        xStreamForRequestPostData.alias("xml", xmlObj.getClass());

        //将要提交给API的数据对象转换成XML格式数据Post给API
        String postData = xStreamForRequestPostData.toXML(xmlObj);
*/
        String postData = JSONObject.toJSONString(xmlObj);
        
        Util.log("API，POST过去的数据是：");
        Util.log(postData);

        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(postData, "UTF-8");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(postEntity);

        //设置请求器的配置
        httpPost.setConfig(requestConfig);

        Util.log("executing request" + httpPost.getRequestLine());

        try {
            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");

        } catch (Exception e) {
            log.e(String.format("http get throw Exception:%s", e.getMessage()));
            throw e;
        } finally {
            httpPost.abort();
        }
        
    
        
        return result;
    }

    /**
     * 设置连接超时时间
     *
     * @param socketTimeout 连接时长，默认10秒
     */
    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
        resetRequestConfig();
    }

    /**
     * 设置传输超时时间
     *
     * @param connectTimeout 传输时长，默认30秒
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        resetRequestConfig();
    }

    private void resetRequestConfig() {
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
    }

    /**
     * 允许商户自己做更高级更复杂的请求器配置
     *
     * @param requestConfig 设置HttpsRequest的请求器配置
     */
    public void setRequestConfig(RequestConfig requestConfig) {
        this.requestConfig = requestConfig;
    }

//	public WXPayConfigData getSpConfigData() {
//		return spConfigData;
//	}
//
//	public void setSpConfigData(WXPayConfigData spConfigData) {
//		this.spConfigData = spConfigData;
//	}
    
}
