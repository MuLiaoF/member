package cn.wandingkeji.comm.enums;
/**
 * 商品类型
 * @author Administrator
 *
 */
public enum ProductTypeEnum {
	/**
	 * 商品券类型
	 */
	TICKET("1","券"),
	/**
	 * 付费卡
	 */
	RC("2","付费卡"),
	/**
	 * 免费卡
	 */
	FC("3","免费卡"),
	/**
	 * 商品未知类型
	 */
	UNKNOW("4","未知类型");
	private String proCode="";
	private String proMsg="";
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getProMsg() {
		return proMsg;
	}
	public void setProMsg(String proMsg) {
		this.proMsg = proMsg;
	}
	private ProductTypeEnum(String proCode, String proMsg) {
		this.proCode = proCode;
		this.proMsg = proMsg;
	}
	
}
