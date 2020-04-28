package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.code;

import java.util.List;

/**
 * @author fjr
 *
 *核查code接口
 */
public class CheckCodeReq {
	

	public CheckCodeReq() {
		// TODO Auto-generated constructor stub
	}
	private String card_id;
	private List<String> code;

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
