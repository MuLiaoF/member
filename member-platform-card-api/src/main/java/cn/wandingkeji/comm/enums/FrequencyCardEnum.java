package cn.wandingkeji.comm.enums;
/**
 * 计次卡次数变动类型
 * @author Administrator
 *
 */
public enum FrequencyCardEnum {
	/**
	 * ADD 增加次数
	 */
	Add("ADD","增加次数"),
	/**
	 * 0 -- 更新添加失败
	 */
	SUBTRACT("SUBTRACT","扣减次数");
	
	private String type;
	private String msg;
	private FrequencyCardEnum(String type, String msg) {
		this.msg=msg;
		this.type=type;
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
