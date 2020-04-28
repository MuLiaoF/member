package cn.wandingkeji.comm.enums;

public enum AccessTokenType {

	
	/**
	 * token type
	 */
	TYPE_1(1,"微信支付服务商的token"),
	TYPE_2(2,"微信支付小微服务商的token"),//
	TYPE_3(3,"富友支付大商户号的token"),//自20171120日废弃
	TYPE_4(4,"微信商户token类型"),
	TYPE_41(41,"初始化jssdk的config的token"),
	TYPE_42(42,"js-sdk中调用js接口的token类型"),
	TYPE_5(5,"微信第三方平台的token类型"),
	TYPE_6(6,"支付宝商户token类型"),
	TYPE_7(7,"小程序token类型");
	
	private int type;
	private String desc;
	private AccessTokenType(int type, String desc){
		this.type = type;
		this.desc = desc;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
