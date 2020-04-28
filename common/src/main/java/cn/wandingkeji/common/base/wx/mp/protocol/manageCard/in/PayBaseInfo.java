package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in;

import java.util.List;

/*
 * add by ws 0515
 * 设置支付后投放卡券接口req的数据
 */
public class PayBaseInfo {

	private List<String> mchid_list;
	private String begin_time;
	private String end_time;
	public List<String> getMchid_list() {
		return mchid_list;
	}
	public void setMchid_list(List<String> mchid_list) {
		this.mchid_list = mchid_list;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	
}
