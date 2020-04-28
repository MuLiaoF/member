package cn.wandingkeji.common.base.wx.mp.util;
/*
 * 微信返回状态码
 * add by ws
 * 20190517
 */
public enum ErrorCode {

	SUCCESS("0","成功"),
	ERROR("1","成功");
	
	
	private String errorCode;
	private String message;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private ErrorCode(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	
	
}
