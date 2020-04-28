package cn.wandingkeji.common.base.wx.mp.protocol.store.in;
/*
 * 查询门店列表
 * add by ws 0513
 */
public class GetStoreInfoReq {

	private int begin;
	private int limit;
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
