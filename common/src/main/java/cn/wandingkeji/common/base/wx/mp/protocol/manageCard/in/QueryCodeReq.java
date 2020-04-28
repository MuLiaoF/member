package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in;
/*
 * 查询Code接口req
 * add by ws 0508
 */
public class QueryCodeReq {

	private String code;
	private String card_id;
	private boolean check_consume;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public boolean isCheck_consume() {
		return check_consume;
	}
	public void setCheck_consume(boolean check_consume) {
		this.check_consume = check_consume;
	}
	
	
}
