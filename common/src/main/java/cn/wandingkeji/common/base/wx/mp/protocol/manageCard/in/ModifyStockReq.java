package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in;
/*
 * 修改库存接口
 * add by ws 0508
 */
public class ModifyStockReq {

	private String card_id;  //卡券ID。
	private int increase_stock_value;  //增加多少库存
	private int reduce_stock_value;   //减少多少库存
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public int getIncrease_stock_value() {
		return increase_stock_value;
	}
	public void setIncrease_stock_value(int increase_stock_value) {
		this.increase_stock_value = increase_stock_value;
	}
	public int getReduce_stock_value() {
		return reduce_stock_value;
	}
	public void setReduce_stock_value(int reduce_stock_value) {
		this.reduce_stock_value = reduce_stock_value;
	}
	
	
}
