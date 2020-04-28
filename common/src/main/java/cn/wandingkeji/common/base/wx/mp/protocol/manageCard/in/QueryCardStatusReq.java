package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in;
/*
 * 查看卡券详情
 * 开发者可以调用该接口查询某个card_id的创建信息、审核状态以及库存数量。
 * add by ws 0515
 */
public class QueryCardStatusReq {

	private String card_id;

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	
	
}
