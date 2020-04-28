package cn.wandingkeji.common.base.wx.mp.protocol.memberCard;

import java.util.Map;

/*
 * 更新会员卡信息的memberCard
 */
public class UpdateMemberCard {

	private String background_pic_url;
	private boolean supply_bonus ;
	private boolean supply_balance ;
	private String prerogative ;
	private boolean auto_activate ;
	private boolean wx_activate ;
	private String activate_url;
	private int discount;
	
	AdvancedInfo advanced_info;

	Map<String,Object> custom_field1;
	Map<String,Object> custom_field2;
	Map<String,Object> custom_field3;
	Map<String,Object> custom_cell1;
	BonusRule bonus_rule;
	
	private UpdateCardBaseInfo base_info;
	public boolean isWx_activate() {
		return wx_activate;
	}
	public void setWx_activate(boolean wx_activate) {
		this.wx_activate = wx_activate;
	}
	public String getBackground_pic_url() {
		return background_pic_url;
	}
	public UpdateMemberCard setBackground_pic_url(String background_pic_url) {
		this.background_pic_url = background_pic_url;
		return this;
	}
	public boolean isSupply_bonus() {
		return supply_bonus;
	}
	public UpdateMemberCard setSupply_bonus(boolean supply_bonus) {
		this.supply_bonus = supply_bonus;
		return this;
	}
	public boolean isSupply_balance() {
		return supply_balance;
	}
	public UpdateMemberCard setSupply_balance(boolean supply_balance) {
		this.supply_balance = supply_balance;
		return this;
	}
	public String getPrerogative() {
		return prerogative;
	}
	public UpdateMemberCard setPrerogative(String prerogative) {
		this.prerogative = prerogative;
		return this;
	}
	public boolean isAuto_activate() {
		return auto_activate;
	}
	public UpdateMemberCard setAuto_activate(boolean auto_activate) {
		this.auto_activate = auto_activate;
		return this;
	}
	public String getActivate_url() {
		return activate_url;
	}
	public UpdateMemberCard setActivate_url(String activate_url) {
		this.activate_url = activate_url;
		return this;
	}
	public int getDiscount() {
		return discount;
	}
	public UpdateMemberCard setDiscount(int discount) {
		this.discount = discount;
		return this;
	}
	public AdvancedInfo getAdvanced_info() {
		return advanced_info;
	}
	public UpdateMemberCard setAdvanced_info(AdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
		return this;
	}
	public Map<String, Object> getCustom_field1() {
		return custom_field1;
	}
	public UpdateMemberCard setCustom_field1(Map<String, Object> custom_field1) {
		this.custom_field1 = custom_field1;
		return this;
	}
	public Map<String, Object> getCustom_field2() {
		return custom_field2;
	}
	public UpdateMemberCard setCustom_field2(Map<String, Object> custom_field2) {
		this.custom_field2 = custom_field2;
		return this;
	}
	public Map<String, Object> getCustom_field3() {
		return custom_field3;
	}
	public UpdateMemberCard setCustom_field3(Map<String, Object> custom_field3) {
		this.custom_field3 = custom_field3;
		return this;
	}
	public Map<String, Object> getCustom_cell1() {
		return custom_cell1;
	}
	public UpdateMemberCard setCustom_cell1(Map<String, Object> custom_cell1) {
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
public UpdateCardBaseInfo getBase_info() {
	return base_info;
}
public void setBase_info(UpdateCardBaseInfo base_info) {
	this.base_info = base_info;
}




}
