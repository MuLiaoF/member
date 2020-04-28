package cn.wandingkeji.common.base.wx.mp.util;

/**
 * Created by xiexiaoxiao on 16/6/24.
 */
public class WXPayExcepFactor extends ExcepFactor {
    public static final WXPayExcepFactor E_RETURN_CODE_ERROR = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 1,
            "return code error!", "返回码错误!");

    public static final WXPayExcepFactor E_RETURN_CODE_FAIL = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 2,
            "return code fail!", "系统返回失败!");

    public static final WXPayExcepFactor E_SIGN_INVALID = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 3,
            "sign invalid!", "签名验证失败!");

    public static final WXPayExcepFactor E_UNIFIED_ORDER_FAIL = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 4,
            "unified order fail!", "统一下单失败!");

    public static final WXPayExcepFactor E_ORDER_PAID = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 5,
            "order paid!", "商户订单已支付!");

    public static final WXPayExcepFactor E_ORDER_CLOSED = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 6,
            "order closed!", "订单已关闭!");

    public static final WXPayExcepFactor E_OUT_TRADE_NO_USED = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 7,
            "out trade no used!", "商户订单号重复!");

    public static final WXPayExcepFactor E_ORDER_NOT_EXIST = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 8,
            "order not exist!", "订单不存在!");

    public static final WXPayExcepFactor E_CLOSE_ORDER_FAIL = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 9,
            "close order fail!", "关闭订单失败!");

    public static final WXPayExcepFactor E_SHORT_URL_FAIL = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 10,
            "short url fail!", "转换短链接失败!");
    

    public static final WXPayExcepFactor E_AUTH_CODE_EXPIRE = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 11,
            "auth code expire!", "二维码已过期!");

    public static final WXPayExcepFactor E_AUTH_CODE_INVALID = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 12,
            "auth code invalid!", "授权码检验错误!");

    public static final WXPayExcepFactor E_NOT_ENOUGH = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 13,
            "not enough!", "余额不足!");

    public static final WXPayExcepFactor E_SCAN_PAY_FAIL = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 14,
            "scan pay fail!", "支付失败!");
    public static final WXPayExcepFactor E_SUBMCH_QUERY_FAIL = new WXPayExcepFactor(
    		HttpStatus.BAD_REQUEST, 15,
    		"submch query fail!", "查询个人收款用户资料失败!");
    public static final WXPayExcepFactor E_SUBMCH_ADD_FAIL = new WXPayExcepFactor(
    		HttpStatus.BAD_REQUEST, 16,
    		"submch add fail!", "添加个人收款用户资料失败!");
    public static final WXPayExcepFactor E_REFUND_FAIL = new WXPayExcepFactor(
    		HttpStatus.BAD_REQUEST, 17,
    		"refund fail!", "退款请求失败!");
    public static final WXPayExcepFactor E_SENDREDPACK_FAIL = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 18,
            "send  fail!", "发放红包失败!");
    public static final WXPayExcepFactor E_NOTENOUGH_FAIL = new WXPayExcepFactor(
    		HttpStatus.BAD_REQUEST, 19,
    		"account no enough amount!", "账户余额不足");
    public static final WXPayExcepFactor E_GOON_FAIL = new WXPayExcepFactor(
    		HttpStatus.BAD_REQUEST, 20,
    		"try again!", "领取失败");
    
    public static final WXPayExcepFactor E_SCAN_PAY_UNKONW = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 21,
            "scan pay fail!", "支付状态未知!");
    public static final WXPayExcepFactor E_AUTH_TO_OPENID_FAIL = new WXPayExcepFactor(
            HttpStatus.BAD_REQUEST, 22,
            "authcode to openid fail!", "授权码查询openid失败!");

    
    public WXPayExcepFactor(HttpStatus httpStatus, int errorCode, String errorMsg, String errorMsgCn) {
        super(2, httpStatus, errorCode, errorMsg, errorMsgCn);
    }
}
