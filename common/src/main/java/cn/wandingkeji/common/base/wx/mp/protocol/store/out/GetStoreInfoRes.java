package cn.wandingkeji.common.base.wx.mp.protocol.store.out;

import java.util.List;
import java.util.Map;

/*
 * 查询门店列表
 * add by ws0513
 */
public class GetStoreInfoRes {

	private String errcode;
	private String errmsg;
	private int total_count;
	private List<Map<String,StoreBaseInfo>> business_list;
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public List<Map<String, StoreBaseInfo>> getBusiness_list() {
		return business_list;
	}
	public void setBusiness_list(List<Map<String, StoreBaseInfo>> business_list) {
		this.business_list = business_list;
	}

	
	
	
	
}
