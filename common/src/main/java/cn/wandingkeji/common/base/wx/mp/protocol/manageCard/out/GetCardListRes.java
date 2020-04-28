package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out;

import java.util.List;
import java.util.Map;

/*
 * 获取用户已领取卡券接口res
 * add by ws 170508
 */
public class GetCardListRes extends CommResData{

	private boolean has_share_card;
	/*
	 *   {"code": "xxx1434079154", "card_id": "xxxxxxxxxx"},
      {"code": "xxx1434079155", "card_id": "xxxxxxxxxx"}
	 */
	private List<Map<String,Object>> card_list;
	public boolean isHas_share_card() {
		return has_share_card;
	}
	public void setHas_share_card(boolean has_share_card) {
		this.has_share_card = has_share_card;
	}
	public List<Map<String, Object>> getCard_list() {
		return card_list;
	}
	public void setCard_list(List<Map<String, Object>> card_list) {
		this.card_list = card_list;
	}
	
	
	
}
