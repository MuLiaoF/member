package cn.wandingkeji.comm.enums;
/*
 * 支付状态枚举类
 * add by ws
 *  20190625
 */
public enum PayStatusEnum {
	INSERT ("0","初始添加"),
	SUCCESS("1","支付成功"),
	FAIL("2","支付失败"),
	REFUNDSUCCESS("3","退款成功"),
	REFUNDFAIL("4","支付失败"),
	REFUNDING("5","申请退款中");
	private String status;
	private String message;
	
	private PayStatusEnum(String status, String message){
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
