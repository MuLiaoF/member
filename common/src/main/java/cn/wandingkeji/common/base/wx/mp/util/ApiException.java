package cn.wandingkeji.common.base.wx.mp.util;

import java.util.HashMap;
import java.util.Map;

public class ApiException extends RuntimeException {

    private final Map<String, Object> parameters = new HashMap<String, Object>();
    private ExcepFactor factor;
    private static final long serialVersionUID = -6705744099814945437L;

    public ApiException() {
        factor = ExcepFactor.E_DEFAULT;
    }

    public ApiException(ExcepFactor factor) {
        this(factor, factor.getErrorMsg());
    }

    public ApiException(ExcepFactor factor, Object message) {
        super((message == null ? factor.getErrorMsg() : message.toString()));
        this.factor = factor;
    }

    public ApiException(ExcepFactor factor, Object[] args) {
        this(factor, factor.getErrorMsg(args));
    }

    //FIXME 默认异常不应该输出详细错误信息？
    public ApiException(Exception e) {
        this(ExcepFactor.E_DEFAULT, e.getMessage());
    }

    public ApiException(String message) {
        this(ExcepFactor.E_DEFAULT, message);
    }

    public void setTraceHeader(String name, Object value) {
        getTraceHeaders().put(name, value);
    }

    public Map<String, Object> getTraceHeaders() {
        return parameters;
    }

    public ExcepFactor getFactor() {
        return factor;
    }

}