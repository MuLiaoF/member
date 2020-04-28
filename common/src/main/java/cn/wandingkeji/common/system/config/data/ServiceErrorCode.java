package cn.wandingkeji.common.system.config.data;

import cn.wandingkeji.common.system.config.dataApi.ErrorCode;

public enum ServiceErrorCode implements ErrorCode {

	REDIS_ERROR(BasicErrorCode.INFRA_ERROR.getCode(), BasicErrorCode.INFRA_ERROR.getMsg(), "3005","服务暂不可用，稍后重试"),
	MYSQL_ERROR(BasicErrorCode.INFRA_ERROR.getCode(), BasicErrorCode.INFRA_ERROR.getMsg(),"3006", "服务暂不可用，稍后重试");
	ServiceErrorCode(String code, String msg, String subCode, String subMsg) {
		this.code = code;
		this.msg = msg;
		this.subCode = subCode;
		this.subMsg = subMsg;
	}

	private String code;
	private String msg;
	private String subCode;
	private String subMsg;

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

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getSubMsg() {
		return subMsg;
	}

	public void setSubMsg(String subMsg) {
		this.subMsg = subMsg;
	}

}
