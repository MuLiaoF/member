package cn.wandingkeji.comm.enums;

public enum WriteOff {
	
	/**
	 * 状态码
	 * 0 -- 成功
	 */
	ERRCODE("0","成功"),
	/**
	 * 核销卡券
	 * 1 -- 领取可核销
	 */
	STA1("1","可核销"),
	/**
	 * 2 -- 不可核销
	 */
	STA2("2","不可核销"),
	/**
	 * 消费
	 * 1 -- 消费
	 */
	SIGN1("1","消费"),
	/**
	 * 充值
	 * 2 -- 充值
	 */
	SIGN2("2","充值"),
	/**
	 * 领卡券
	 * 1 -- 领取可核销
	 */
	COU1("1","领取可核销"),
	/**
	 * 领卡券
	 * 2 -- 领取已核销
	 */
	COU2("2","领取已核销");
	
	private String sta;
	private String msg;
	private WriteOff(String sta, String msg) {
		this.msg=msg;
		this.sta=sta;
	}
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
