package cn.wandingkeji.common.base.wx.mp.protocol.store.in;
/*
 * 查询微信门店小程序列表
 * add by ws 0912
 */
public class GetStoreListReq {

	private int offset;
	private int limit;

	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
