package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in;
/*
 * 批量查询支付后投放卡券规则接口
 * add by ws 0508
 */
public class BatchgetByPayGiftCardReq {

	private String type="RULE_TYPE_PAY_MEMBER_CARD";
    private boolean effective=true;
    private int offset;
    private int count;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isEffective() {
		return effective;
	}
	public void setEffective(boolean effective) {
		this.effective = effective;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
    
    
	
}
