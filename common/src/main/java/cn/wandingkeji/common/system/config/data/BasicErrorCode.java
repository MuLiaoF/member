package cn.wandingkeji.common.system.config.data;


import cn.wandingkeji.common.system.config.dataApi.ErrorCode;

/**
 * 参数错误：1000 - 1999 业务错误：2000 - 2999 基础错误：3000 - 3999 系统错误：4000 - 4999
 * 
 * @author liaoxiang
 *
 */
public enum BasicErrorCode implements ErrorCode {

	PARAM_ERROR("1000", "参数校验错误"), BIZ_ERROR("2000", "业务处理失败"),
	/**
	 * (数据库，缓存，消息等)
	 */
	INFRA_ERROR("3000", "服务不可用"), SYS_ERROR("4000", "系统错误");

	BasicErrorCode(String code, String msg) {
		this.code = code;
		this.msg = msg;

	}

	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
