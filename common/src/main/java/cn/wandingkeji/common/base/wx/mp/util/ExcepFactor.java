package cn.wandingkeji.common.base.wx.mp.util;

import java.io.Serializable;

public class ExcepFactor implements Serializable {

    private static final long serialVersionUID = 3200247233681177606L;
    // 系统级异常
    public static final int ERROR_LEVEL_SYSTEM = 1;
    // 服务级异常
    public static final int ERROR_LEVEL_SERVICE = 2;

//    private static final Set<ExcepFactor> excepFactors = new HashSet<ExcepFactor>();

    /**
     * 默认错误
     */
    public static final ExcepFactor E_DEFAULT = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.INTERNAL_SERVER_ERROR, 1,
            "system error!", "系统错误!");

    /**
     * 服务端资源不可用
     */
    public static final ExcepFactor E_SERVICE_UNAVAILABLE = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.SERVICE_UNAVAILABLE, 2,
            "service unavailable!", "服务端资源不可用!");


    /**
     * 远程接口错误
     */
    public static final ExcepFactor E_REMOTE_ERROR = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.SERVICE_UNAVAILABLE, 3,
            "remote service error!", "远程服务出错");

    /**
     * IP限制，不能请求该资源
     */
    public static final ExcepFactor E_IP_LIMIT = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.BAD_REQUEST, 4,
            "IP limit!", "IP限制，不能请求该资源!");

    /**
     * 来源级别错误
     */
    public static final ExcepFactor E_SOURCE_LEVEL_ERROR = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.FORBIDDEN, 5,
            "permission denied! Need a high level appkey!",
            "该资源需要appkey拥有更高级的授权!");


    /**
     * 来源不对
     */
    public static final ExcepFactor E_SOURCE_ERROR = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.BAD_REQUEST, 6,
            "source paramter(spid) is missing", "缺少 source参数(spid)!");


    public static final ExcepFactor E_UNSUPPORT_MEDIATYPE_ERROR = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.UNSUPPORTED_MEDIA_TYPE, 7,
            "unsupport mediatype (%s)", "不支持的 MediaType (%s).");

    public static final ExcepFactor E_PARAM_ERROR = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.BAD_REQUEST, 8,
            "param error, see doc for more info.", "错误:参数错误，请参考API文档!");

    public static final ExcepFactor E_SYSTEM_BUSY = new ExcepFactor(ERROR_LEVEL_SYSTEM, 0,
            HttpStatus.SERVICE_UNAVAILABLE, 9,
            "Too many pending tasks, system is busy!", "任务过多，系统繁忙!");
    public static final ExcepFactor E_JOB_EXPIRED = new ExcepFactor(ERROR_LEVEL_SYSTEM, 0,
            HttpStatus.SERVICE_UNAVAILABLE, 10, "Job Expired", "任务超时!");
    public static final ExcepFactor E_RPC_ERROR = new ExcepFactor(ERROR_LEVEL_SYSTEM, 0,
            HttpStatus.SERVICE_UNAVAILABLE, 11, "RPC ERROR", "RPC错误!");

    public static final ExcepFactor E_ILLEGAL_REQUEST = new ExcepFactor(ERROR_LEVEL_SYSTEM, 0,
            HttpStatus.BAD_REQUEST, 12, "Illegal Request!", "非法请求!");

    /**
     * 应用访问api接口权限受限制
     */
    public static final ExcepFactor E_APP_API_LIMIT = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.FORBIDDEN, 14,
            "Insufficient app permissions!", "第三方应用访问api接口权限受限制");


    public static final ExcepFactor E_PARAM_MISS_ERROR = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.BAD_REQUEST, 16,
            "miss required parameter (%s), see doc for more info.",
            "错误:缺失必选参数:%s，请参考API文档.");
    public static final ExcepFactor E_PARAM_INVALID_ERROR = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.BAD_REQUEST, 17,
            "parameter (%s)'s value invalid, expect (%s), but get (%s), see doc for more info.",
            "错误:参数 (%s) 值非法, 希望得到 (%s), 实际得到 (%s), 请参考API文档.");

    public static final ExcepFactor E_POST_BODY_LENGTH_LIMIT = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.BAD_REQUEST, 18,
            "request boday length over limit.", "请求长度超过限制!");

    /**
     * 接口不存在
     */
    public static final ExcepFactor E_API_NOT_EXIST = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.NOT_FOUND, 20,
            "Request Api not found!",
            "接口不存在!");

    /**
     * Http 方法错误
     */
    public static final ExcepFactor E_METHOD_ERROR = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.METHOD_NOT_ALLOWED, 21,
            "HTTP METHOD is not suported for this request!",
            "请求的HTTP METHOD不支持!");

    /**
     * 用户IP次数达到限制
     */
    public static final ExcepFactor E_IP_OUTOFLIMIT = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.FORBIDDEN, 22,
            "IP requests out of rate limit!", "IP请求超过上限!");

    /**
     * 用户请求次数达到限制
     */
    public static final ExcepFactor E_USER_OUTOFLIMIT = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.FORBIDDEN, 23,
            "User requests out of rate limit!", "用户请求超过上限!");


    /**
     * 用户对特定接口的请求次数达到限制
     */
    public static final ExcepFactor E_API_OUTOFLIMIT = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.FORBIDDEN, 24,
            "User requests for %s out of rate limit!", "用户请求接口%s超过上限!");

    /**
     * 调用内部服务 接口参数错误
     */
    public static final ExcepFactor E_INTERNAL_PARAM_ERROR = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.BAD_REQUEST, 25,
            "internal service param error.", "内部接口参数错误");

    /**
     * 接口已经废弃
     */
    public static final ExcepFactor E_API_DEPRECATED_ERROR = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.SERVICE_UNAVAILABLE, 26,
            "api is deprecated.", "该接口已经废弃");

    /**
     * 用户请求次数达到限制
     */
    public static final ExcepFactor E_APPRES_OUTOFLIMIT = new ExcepFactor(
            ERROR_LEVEL_SYSTEM, 0, HttpStatus.FORBIDDEN, 27,
            "appkey requests out of resource limit!", "app的资源超过上限!");

    /**
     * 没有填写uid参数
     */
    public static final ExcepFactor E_NO_UID = new ExcepFactor(
            ERROR_LEVEL_SERVICE, 0, HttpStatus.BAD_REQUEST, 2,
            "uid  parameter is null!", "uid参数为空!");

    /**
     * 用户不存在
     */
    public static final ExcepFactor E_USER_NOTEXIST = new ExcepFactor(
            ERROR_LEVEL_SERVICE, 0, HttpStatus.BAD_REQUEST, 3,
            "User does not exists!", "用户不存在!");

    public static final ExcepFactor E_APP_AUTHFAIL = new ExcepFactor(
            ERROR_LEVEL_SERVICE, 0, HttpStatus.FORBIDDEN, 4,
            "auth failed!", "认证失败");

    private HttpStatus httpStatus;
    private int level;
    private int serviceId;
    private int errorCode;
    private String errorMsg;
    private String errorMsgCn;

    /**
     * 只用于远程调用构造！
     */
    public ExcepFactor() {

    }

    private ExcepFactor(int level, int serviceId, HttpStatus httpStatus,
                        int errorCode, String errorMsg, String errorMsgCn) {
        if (errorCode <= 0 || errorCode > 99) {
            throw new IllegalArgumentException("errorCode must between 1~99 .");
        }
        if (serviceId < 0 || serviceId > 99) {
            throw new IllegalArgumentException("serviceId must between 1~99 .");
        }
        this.level = level;
        this.serviceId = serviceId;
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errorMsgCn = errorMsgCn;
//        if (excepFactors.contains(this)) {
//            throw new IllegalArgumentException("this error exist: " + this.getErrorCode());
//        }
//        excepFactors.add(this);
    }

    protected ExcepFactor(int serviceId, HttpStatus httpStatus,
                          int errorCode, String errorMsg, String errorMsgCn) {
        this(ERROR_LEVEL_SERVICE, serviceId, httpStatus, errorCode,
                errorMsg, errorMsgCn);
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }

    public int getErrorCode() {
        return this.level * 10000 + this.serviceId * 100 + this.errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getErrorMsg(Object... args) {
        if (args == null || args.length == 0) {
            return errorMsg;
        }
        return String.format(errorMsg, args);
    }

    public String getErrorMsgCn() {
        return errorMsgCn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.getErrorCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ExcepFactor other = (ExcepFactor) obj;
        if (this.getErrorCode() != other.getErrorCode()) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("%s\t%s\t%s", this.getErrorCode(), this.getErrorMsg(), this.getErrorMsgCn());
    }
}
