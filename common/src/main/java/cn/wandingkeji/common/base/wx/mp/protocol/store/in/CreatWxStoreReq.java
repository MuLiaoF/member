package cn.wandingkeji.common.base.wx.mp.protocol.store.in;

import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.BaseInfo;

import java.util.Map;

/*
 * add by ws 0509
 * 创建门店
 */
public class CreatWxStoreReq {

	private Map<String, BaseInfo> business;

	public Map<String, BaseInfo> getBusiness() {
		return business;
	}

	public void setBusiness(Map<String, BaseInfo> business) {
		this.business = business;
	}
	
	
	
}
