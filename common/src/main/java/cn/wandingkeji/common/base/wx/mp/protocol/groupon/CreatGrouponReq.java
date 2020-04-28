package cn.wandingkeji.common.base.wx.mp.protocol.groupon;

/*
 * 创建卡卷javabean 
 * add by ws 
 * 20170505
 */
public class CreatGrouponReq {

	private String card_type="GROUPON";
	private Groupon groupon;
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public Groupon getGroupon() {
		return groupon;
	}
	public void setGroupon(Groupon groupon) {
		this.groupon = groupon;
	}
	
	
}
