package cn.wandingkeji.common.base.wx.mp.protocol.createQrCard;


import java.util.HashMap;
import java.util.Map;

public class ActionInfo {

	Map<String,Object> card;

	public Map<String, Object> getCard() {
		return card;
	}

	public void setCard(Map<String, Object> card) {
		this.card = card;
	}
	public ActionInfo setCard(String card_id,String code,String openid,boolean is_unique_code,String outer_str) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("card_id", card_id);
		map.put("code", code);
		map.put("openid", openid);
		map.put("is_unique_code", is_unique_code);
		map.put("outer_str", outer_str);
		this.card = map;
		return this;
	}
}
