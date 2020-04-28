package cn.wandingkeji.comm.enums;

/**
 * 平台基础数据key的枚举值
 *
 * @author jing_huan
 */
public enum PlatformEnum {
	/**
	 * 会员卡付款转发地址
	 */
	QRPayment("QRPayment","会员卡付款地址"),
	/**
     * 会员分享转发地址
     */
    QRCodeIP("QRCodeIP", "计次卡核销生生二维码跳转地址"),
    /**
     * 会员分享转发地址
     */
    IP("IP", "会员分享转发链接ip的地址"),
   
    /**
     * token的地址
     */
    TOKENURL("TOKENURL", "token的地址"),
    /**
     * 公众号下单接口
     */
    JSAPIPAYURL("JSAPIPAYURL", "公众号下单接口"),
    /**
     * 小程序下单接口地址
     */
    miniPayUrl("miniPayUrl", "小程序下单接口地址"),
    /*
     * 刷卡支付接口
     */
    BARCODEPAY("BARCODEPAY", "刷卡支付接口"),
    /**
     * 微信退款地址
     */
    reFundByWeiXin("weixinReFund", "微信退款接口"),
	
	
	QUERYPAY("QUERYPAY","支付订单查询接口"),
    /*
     * H5领劵页面
     */
	H5LEDTICKET("H5LEDTICKET","H5领劵页面"),
	GETPAYOPENID("GETPAYOPENID","获取支付openid"),

    /**
     * 领取计次卡获取openId
     */
    FREQUENCYOPENID("FREQUENCYOPENID","领取计次卡获取openId"),

    REDIRECTPAYURI("REDIRECTPAYURI","转发微信跳转支付路径"),
	DEPOSIRURL("DEPOSIRURL","会员卡充值页面"),
    /**
     * 支付宝固定金额
     */
    ALIAPIPAYURL("ALIAPIPAYURL", "支付宝固定金额接口"),

    MEM_PAY_NOTIFY_URL("MEM_PAY_NOTIFY_URL","会员支付回调地址"),
    IMAGEURL("IMAGEURL", "图片域名"),
    MEM_DOMAIN("MEM_DOMAIN","会员商城域名"),
    MINITOKENURL("MINITOKENURL","获取小程序tokenurl"),
    DEPOSITNOTIFYURL("DEPOSITNOTIFYURL", "会员卡内充值回调通知"),
    MEM_AUTH_OPEN_URL("MEM_AUTH_OPEN_URL", "会员授权获取OpenId地址"),

    SENDMESSAGE("SENDMESSAGE ","发送短信");


    private String key;
    private String value;

    private PlatformEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
