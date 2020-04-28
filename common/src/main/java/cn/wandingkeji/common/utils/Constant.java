package cn.wandingkeji.common.utils;

public class Constant {
	
	public static String DEFAULT_CHARSET = "UTF-8";
	public static String domain;// weixin.weupay.com#test.weupay.cn
	public static String projectName = "pay";//
	public static String imageRootPath = "/data/upload/image/";
	public static String logoPath = "logo";
	public static String xiaoweiPath = "xiaowei";
	public static String lcPath = "lc";
	public static String adPath = "ad";
	public static String logoSuffix = ".jpg";
	public static int logoSize = 1024 * 1024;
	public static String SP_MID = "1";
	public static String SP_TEMPLET = "4";// 默认用发送模板信息的公众号配置access_token�?
	public static int FAIL_NOTIFY_NUM = 1;
	public static String defaultLogo;
	public static String password = "123456";
	public static String productPath = "product";// 积分商城产品�?
	public static String initBalance = "0.00";// 余额默认值字符串
	public static String HEAD_PRO_HTTP = "http://";// http请求协议
	public static final String INSTANCE_ID = System.getProperty("instance-id");
	public static String TOKEN_URL;
	public static String FORCE_FLUSH_TOKEN_URL;
	public static String SEND_REFUND_URL;
    public static String SKYYBB_SEND_MSG_URL;
    public static String SKYYBB_BATCH_SEND_MSG_URL;
    public static String SKYYBB_DESTORY_CONNECT_URL;
    public static String SKYYBB_CREDENTIAL_URL;
    public static String frontUrl="";
    public static String getTokenUrl="";
    /**
     * 时间戳  一天 86400000
     */
    public static int ONE_DAY=86400000;
    public Constant() {
    	
    }

	public static int getONE_DAY() {
		return ONE_DAY;
	}

	public static void setONE_DAY(int oNE_DAY) {
		ONE_DAY = oNE_DAY;
	}

	public static String getGetTokenUrl() {
		return getTokenUrl;
	}

	public static void setGetTokenUrl(String getTokenUrl) {
		Constant.getTokenUrl = getTokenUrl;
	}

	public static String getFrontUrl() {
		return frontUrl;
	}

	public static void setFrontUrl(String frontUrl) {
		Constant.frontUrl = frontUrl;
	}

	public void setDomain(String domain) {
		Constant.domain = domain;
	}

	public void setDefaultLogo(String defaultLogo) {
		Constant.defaultLogo = defaultLogo;
	}

	public void setTOKEN_URL(String tOKEN_URL) {
		Constant.TOKEN_URL = tOKEN_URL;
	}

	public void setFORCE_FLUSH_TOKEN_URL(String fORCE_FLUSH_TOKEN_URL) {
		Constant.FORCE_FLUSH_TOKEN_URL = fORCE_FLUSH_TOKEN_URL;
	}

	public void setSEND_REFUND_URL(String sEND_REFUND_URL) {
		Constant.SEND_REFUND_URL = sEND_REFUND_URL;
	}

    public static void setSKYYBB_SEND_MSG_URL(String sKYYBB_SEND_MSG_URL) {
        Constant.SKYYBB_SEND_MSG_URL = sKYYBB_SEND_MSG_URL;
    }

    public static void setSKYYBB_BATCH_SEND_MSG_URL(String sKYYBB_BATCH_SEND_MSG_URL) {
        Constant.SKYYBB_BATCH_SEND_MSG_URL = sKYYBB_BATCH_SEND_MSG_URL;
    }

    public static void setSKYYBB_DESTORY_CONNECT_URL(String sKYYBB_DESTORY_CONNECT_URL) {
        Constant.SKYYBB_DESTORY_CONNECT_URL = sKYYBB_DESTORY_CONNECT_URL;
    }

    public static void setSKYYBB_CREDENTIAL_URL(String sKYYBB_CREDENTIAL_URL) {
        Constant.SKYYBB_CREDENTIAL_URL = sKYYBB_CREDENTIAL_URL;
    }
    
    

}
