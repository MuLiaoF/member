package cn.wandingkeji.common.enums;

public enum ErrorCode {

	LOGIN_TIME_CODE (301,"登录超时！"),
	ERROR_ROLE(302,"尚未登录，请重新登录"),
	SUCCESS(200,"成功"),
	DEFAULT_ERROR(300,"操作失败！");

	private int errorCode = 0;
	private String errorMsg = "";
	private ErrorCode(int errorCode, String errorMsg){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
