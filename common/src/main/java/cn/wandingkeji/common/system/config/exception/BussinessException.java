package cn.wandingkeji.common.system.config.exception;

public class BussinessException extends Exception{
	
	public static final String SocketTimeout ="SocketTimeoutException";
	public static final String NoHttpResponse ="NoHttpResponseException";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private   String  errorCode;

	public BussinessException(String errorCode, String errorMsg) {
		 super((errorMsg == null ? "异常" : errorMsg.toString()));
		 this.errorCode = errorCode;
	}

	public  String getErrorcode() {
		return errorCode;
	}

}
