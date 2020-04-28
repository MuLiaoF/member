package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * add by ws 20170508
 * 设置支付后赠券时POST数据内的参数对象
 */
public class SinglePay {

	private String title;
	private List<Map<String,Object>> info_list;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Map<String, Object>> getInfo_list() {
		return info_list;
	}
	public void setInfo_list(List<Map<String, Object>> info_list) {
		this.info_list = info_list;
	}
	public SinglePay setInfo_list(String card_id,BigDecimal amount) {
		List<Map<String,Object>> list=new ArrayList<>();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("card_id", card_id);
		map.put("amount",amount);
		list.add(map);
		this.info_list = list;
		return this;
	}
	
	
	
}
