package cn.wandingkeji.comm.enums;

public enum NumSuc {
	/**
	 * 1 -- 更新添加成功
	 */
	SUCEESS(1,"成功"),
	/**
	 * 0 -- 更新添加失败
	 */
	ERROR(0,"失败");
	
	private int sta;
	private String msg;
	private NumSuc(int sta, String msg) {
		this.msg=msg;
		this.sta=sta;
	}
	public int getSta() {
		return sta;
	}
	public void setSta(int sta) {
		this.sta = sta;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
