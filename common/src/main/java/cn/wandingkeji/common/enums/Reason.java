package cn.wandingkeji.common.enums;

public enum Reason {

	deposit("1","充值"),
	withdraw("2","消费"),
	exchange("3","积分兑换"),
	first("4","领卡赠送"),
	other("5","其它"),
	masterout("6","绑定支出"),
	masterin("7","解绑存入"),
	vicein("8","绑定存入"),
	viceout("9","解绑支出"),
	refund("10","退款订单"),
	bounsDeduct("11","积分抵扣");
	
	private String reason_id;
	private String comments;
	public String getReason_id() {
		return reason_id;
	}
	public void setReason_id(String reason_id) {
		this.reason_id = reason_id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	private Reason(String reason_id, String comments){
		this.reason_id = reason_id;
		this.comments = comments;
	}
	public Reason getReasonByReasonId(String reason_id){
		//
		Reason[] values = Reason.values();
		return null;
	}
}
