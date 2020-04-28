package cn.wandingkeji.common.base.wx.mp.protocol.memberCard;

import java.util.Map;

public class MemberCard {

	private String background_pic_url;
	private boolean supply_bonus = true;
	private boolean supply_balance = false;
	private String prerogative = "test_prerogative";
	private boolean auto_activate = false;
	private boolean wx_activate =true;
	private boolean wx_activate_after_submit ;//是否支持跳转型一键激活
	private String wx_activate_after_submit_url ;//跳转型一键激活跳转的地址链接
	private String activate_app_brand_user_name ;//激活会原卡url对应的小程序user_name，仅可跳转该公众号绑定的小程序
	private String activate_app_brand_pass;//激活会原卡url对应的小程序path
	private String activate_url;
	private int discount;
	private CardBaseInfo base_info;
	
	AdvancedInfo advanced_info;

	Map<String,Object> custom_field1;
	Map<String,Object> custom_field2;
	Map<String,Object> custom_field3;
	Map<String,Object> custom_cell1;
//	Map<String,Object> bonus_rule;
	BonusRule bonus_rule;
	
	public boolean isWx_activate_after_submit() {
		return wx_activate_after_submit;
	}
	public void setWx_activate_after_submit(boolean wx_activate_after_submit) {
		this.wx_activate_after_submit = wx_activate_after_submit;
	}
	public String getWx_activate_after_submit_url() {
		return wx_activate_after_submit_url;
	}
	public void setWx_activate_after_submit_url(String wx_activate_after_submit_url) {
		this.wx_activate_after_submit_url = wx_activate_after_submit_url;
	}
	public String getActivate_app_brand_user_name() {
		return activate_app_brand_user_name;
	}
	public void setActivate_app_brand_user_name(String activate_app_brand_user_name) {
		this.activate_app_brand_user_name = activate_app_brand_user_name;
	}
	public String getActivate_app_brand_pass() {
		return activate_app_brand_pass;
	}
	public void setActivate_app_brand_pass(String activate_app_brand_pass) {
		this.activate_app_brand_pass = activate_app_brand_pass;
	}
	public boolean isWx_activate() {
		return wx_activate;
	}
	public void setWx_activate(boolean wx_activate) {
		this.wx_activate = wx_activate;
	}
	public String getBackground_pic_url() {
		return background_pic_url;
	}
	public MemberCard setBackground_pic_url(String background_pic_url) {
		this.background_pic_url = background_pic_url;
		return this;
	}
	public boolean isSupply_bonus() {
		return supply_bonus;
	}
	public MemberCard setSupply_bonus(boolean supply_bonus) {
		this.supply_bonus = supply_bonus;
		return this;
	}
	public boolean isSupply_balance() {
		return supply_balance;
	}
	public MemberCard setSupply_balance(boolean supply_balance) {
		this.supply_balance = supply_balance;
		return this;
	}
	public String getPrerogative() {
		return prerogative;
	}
	public MemberCard setPrerogative(String prerogative) {
		this.prerogative = prerogative;
		return this;
	}
	public boolean isAuto_activate() {
		return auto_activate;
	}
	public MemberCard setAuto_activate(boolean auto_activate) {
		this.auto_activate = auto_activate;
		return this;
	}
	public String getActivate_url() {
		return activate_url;
	}
	public MemberCard setActivate_url(String activate_url) {
		this.activate_url = activate_url;
		return this;
	}
	public int getDiscount() {
		return discount;
	}
	public MemberCard setDiscount(int discount) {
		this.discount = discount;
		return this;
	}

	public CardBaseInfo getBase_info() {
		return base_info;
	}
	public void setBase_info(CardBaseInfo base_info) {
		this.base_info = base_info;
	}
	public AdvancedInfo getAdvanced_info() {
		return advanced_info;
	}
	public MemberCard setAdvanced_info(AdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
		return this;
	}
	public Map<String, Object> getCustom_field1() {
		return custom_field1;
	}
	public MemberCard setCustom_field1(Map<String, Object> custom_field1) {
		this.custom_field1 = custom_field1;
		return this;
	}
	public Map<String, Object> getCustom_field2() {
		return custom_field2;
	}
	public MemberCard setCustom_field2(Map<String, Object> custom_field2) {
		this.custom_field2 = custom_field2;
		return this;
	}
	public Map<String, Object> getCustom_field3() {
		return custom_field3;
	}
	public MemberCard setCustom_field3(Map<String, Object> custom_field3) {
		this.custom_field3 = custom_field3;
		return this;
	}
	public Map<String, Object> getCustom_cell1() {
		return custom_cell1;
	}
	public MemberCard setCustom_cell1(Map<String, Object> custom_cell1) {
		this.custom_cell1 = custom_cell1;
		return this;
	}
	
	    
public BonusRule getBonus_rule() {
		return bonus_rule;
	}
	public void setBonus_rule(BonusRule bonus_rule) {
		this.bonus_rule = bonus_rule;
	}


private String bonus_cleared; //更改会员卡信息接口用。。。积分清零规则。
public String getBonus_cleared() {
	return bonus_cleared;
}
public void setBonus_cleared(String bonus_cleared) {
	this.bonus_cleared = bonus_cleared;
}


}
