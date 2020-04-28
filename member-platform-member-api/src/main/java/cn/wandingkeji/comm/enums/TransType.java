package cn.wandingkeji.comm.enums;

public enum TransType {

	IN ("IN","存入"),
	OUT("OUT","支出");
	
	private String status;
	private String message;
	private TransType(String status, String message){
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
