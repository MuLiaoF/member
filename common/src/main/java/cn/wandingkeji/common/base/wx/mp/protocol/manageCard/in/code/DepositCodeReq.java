package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.code;

import java.util.List;

/**
 * @author fjr
 *导入code
 */
public class DepositCodeReq {

	public DepositCodeReq() {
	}
	private String card_id;
	private List<String> code;//已经微信卡券后台的自定义code，上限为100个。
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public List<String> getCode() {
		return code;
	}
	public void setCode(List<String> code) {
		this.code = code;
	}
	
	

}
