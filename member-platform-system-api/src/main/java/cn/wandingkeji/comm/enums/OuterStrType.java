package cn.wandingkeji.comm.enums;
/**
 * TODO
 * outerstr来源代表不同的业务
 * @author jing_huan
 *
 */
public enum OuterStrType {
	/**
	 * 团购
	 */
	TB("TB","团购"),
	/**
	 * 拼购
	 */
	PB("PB","拼购"),
	/**
	 * 秒杀
	 */
	MS("MS","秒杀"),
	/**
	 * MFLK--免费领卡
	 */
	MFLK("MFLK","免费领卡"),
	/**
	 * CZLK--充值领卡
	 */
	CZLK("CZLK","付费购卡"),
	
	DH("DH","积分兑换"),
	/*
	 * 充值送劵
	 */
	CZSJ("CZSJ","充值送劵"),

	/**
	 * 付费购卡
	 */
	POSFFGK("POSFFGK","POS付费购卡"),
	/*
	 * 消费送劵
	 */
	CONSUME("CONSUME","消费送劵"),
	/**
	 * MCLB--会员裂变
	 */
	MCLB("MCLB","会员裂变"),

	/**
	 * POS付费购卡
	 */
	POSBUYCARD("POSBUYCARD","POS付费购卡"),
	/**
	 * 员工拓客
	 */
	EMPTOMEMBER("EMPTOMEMBER","员工拓客"),
	
	PUSHMESSAGECARD("PUSHMESSAGECARD","推送消息卡券");
	
	private String type;
	private String msg;
	private OuterStrType(String type, String msg) {
		this.type = type;
		this.msg = msg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
