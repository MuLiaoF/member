package cn.wandingkeji.merchant.entity;

import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@ToString
public class Merchants implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int mid;
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMaccount() {
		return maccount;
	}

	public void setMaccount(String maccount) {
		this.maccount = maccount;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getWxName() {
		return wxName;
	}

	public void setWxName(String wxName) {
		this.wxName = wxName;
	}

	public String getWxNumber() {
		return wxNumber;
	}

	public void setWxNumber(String wxNumber) {
		this.wxNumber = wxNumber;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsSub() {
		return isSub;
	}

	public void setIsSub(int isSub) {
		this.isSub = isSub;
	}

	public int getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}

	public String getThirdMid() {
		return thirdMid;
	}

	public void setThirdMid(String thirdMid) {
		this.thirdMid = thirdMid;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	private String mname;
	private String maccount;
	private String malias;
	private String mpwd;
	private String salt;
	private String memail;
	private String mphone;
	private String wxName;
	private String wxNumber;
	private String logo;
	private int status;
	private int isSub;
	private int isadmin;
	private String thirdMid;
	private int agentId;
	private String parentId;
	private String mtype;
	private String sysAppId;
	private String templetAppId;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private String reserve4;
	private Timestamp create_time;
	private Timestamp update_time;
	private Integer fid;
	private String pay_type;
	private BigDecimal rate;
	private String mpid;
	private int open_mem;//是否开通会员卡功能
	private String card_id;
	//add by fjr 20170607
	private String thirdMkey; //农商行的商户秘钥，方便查询调用支付接口
	private String onechannel;//类型值为Y代表大客户为全渠道通道类型（注：支付都走同一个通道，所谓的全渠道通道即支付宝和微信都是这个通道下的，比如富友、农商行等）
	private String url_wm0;//快速买单url
	//add by ws 20180917
	private String business_type;//商户行业类型。（餐饮零费率和企事业单位零费率不同，代理商计算费率使用）
	//add by ws 19-03-29
	private String isSpecialRate;
	private String specialId;

	
	public String getIsSpecialRate() {
		return isSpecialRate;
	}

	public void setIsSpecialRate(String isSpecialRate) {
		this.isSpecialRate = isSpecialRate;
	}

	public String getSpecialId() {
		return specialId;
	}

	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}

	public String getBusiness_type() {
		return business_type;
	}

	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}

	public String getUrl_wm0() {
		return url_wm0;
	}

	public void setUrl_wm0(String url_wm0) {
		this.url_wm0 = url_wm0;
	}

	public int getOpen_mem() {
		return open_mem;
	}

	public void setOpen_mem(int open_mem) {
		this.open_mem = open_mem;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getMpid() {
		return mpid;
	}

	public void setMpid(String mpid) {
		this.mpid = mpid;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Merchants() {
		// TODO Auto-generated constructor stub
		
		
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getSysAppId() {
		return sysAppId;
	}

	public void setSysAppId(String sysAppId) {
		this.sysAppId = sysAppId;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public String getTempletAppId() {
		return templetAppId;
	}

	public void setTempletAppId(String templetAppId) {
		this.templetAppId = templetAppId;
	}

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	public String getReserve4() {
		return reserve4;
	}

	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4;
	}

	public String getMalias() {
		return malias;
	}

	public void setMalias(String malias) {
		this.malias = malias;
	}

	public String getThirdMkey() {
		return thirdMkey;
	}

	public void setThirdMkey(String thirdMkey) {
		this.thirdMkey = thirdMkey;
	}

	public String getOnechannel() {
		return onechannel;
	}

	public void setOnechannel(String onechannel) {
		this.onechannel = onechannel;
	}
	

}
