package cn.wandingkeji.common.base.wx.mp.protocol.memberCard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 创建会员卡的baseInfo
 */
public class CardBaseInfo {
	private String logo_url;
	private String brand_name;//
	private String code_type;
	private String title;
	private String color;
	private String notice;
	private String service_phone;
	private String description;
	private int get_limit;
	private boolean use_custom_code;
	private String get_custom_code_mode;//自定义code卡券方可进行导入code并投放的动作。
	private String custom_url_name;
	private String custom_url;
	private String custom_url_sub_title;
	private String promotion_url_name;
	private String promotion_url;
	private String promotion_url_sub_title;
	
	private boolean need_push_on_view= false;
	private boolean can_share;
	private boolean can_give_friend;

	private List<String> location_id_list;
	
	Map<String,Object> date_info;
	Map<String,Object> sku;
	
	
	private boolean bind_openid;
	private String center_title;
	private String center_sub_title;
	private String center_url;
	private boolean use_all_locations=false;
	
	public CardBaseInfo setSku(int quantity ) {
		Map<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("quantity",new  Integer(quantity));
		this.sku = hashMap;
		return this;
	}
	/**
	 * 永久有效
	 */
	public CardBaseInfo setDate_info() {
		Map<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("type","DATE_TYPE_PERMANENT");
		this.date_info = hashMap;
		return this;
	}
	public String getLogo_url() {
		return logo_url;
	}
	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getCode_type() {
		return code_type;
	}
	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getService_phone() {
		return service_phone;
	}
	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGet_limit() {
		return get_limit;
	}
	public void setGet_limit(int get_limit) {
		this.get_limit = get_limit;
	}
	public boolean isUse_custom_code() {
		return use_custom_code;
	}
	public void setUse_custom_code(boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
	}
	public String getCustom_url_name() {
		return custom_url_name;
	}
	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}
	public String getCustom_url() {
		return custom_url;
	}
	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}
	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}
	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}
	public String getPromotion_url_name() {
		return promotion_url_name;
	}
	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}
	public String getPromotion_url() {
		return promotion_url;
	}
	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}
	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}
	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}
	public boolean isNeed_push_on_view() {
		return need_push_on_view;
	}
	public void setNeed_push_on_view(boolean need_push_on_view) {
		this.need_push_on_view = need_push_on_view;
	}
	public boolean isCan_share() {
		return can_share;
	}
	public void setCan_share(boolean can_share) {
		this.can_share = can_share;
	}
	public boolean isCan_give_friend() {
		return can_give_friend;
	}
	public void setCan_give_friend(boolean can_give_friend) {
		this.can_give_friend = can_give_friend;
	}
	public List<String> getLocation_id_list() {
		return location_id_list;
	}
	public void setLocation_id_list(List<String> location_id_list) {
		this.location_id_list = location_id_list;
	}
	public Map<String, Object> getDate_info() {
		return date_info;
	}
	public void setDate_info(Map<String, Object> date_info) {
		this.date_info = date_info;
	}
	public Map<String, Object> getSku() {
		return sku;
	}
	public void setSku(Map<String, Object> sku) {
		this.sku = sku;
	}
	public boolean isBind_openid() {
		return bind_openid;
	}
	public void setBind_openid(boolean bind_openid) {
		this.bind_openid = bind_openid;
	}
	public String getCenter_title() {
		return center_title;
	}
	public void setCenter_title(String center_title) {
		this.center_title = center_title;
	}
	public String getCenter_sub_title() {
		return center_sub_title;
	}
	public void setCenter_sub_title(String center_sub_title) {
		this.center_sub_title = center_sub_title;
	}
	public String getCenter_url() {
		return center_url;
	}
	public void setCenter_url(String center_url) {
		this.center_url = center_url;
	}
	public boolean isUse_all_locations() {
		return use_all_locations;
	}
	public void setUse_all_locations(boolean use_all_locations) {
		this.use_all_locations = use_all_locations;
	}
	public String getGet_custom_code_mode() {
		return get_custom_code_mode;
	}
	public void setGet_custom_code_mode(String get_custom_code_mode) {
		this.get_custom_code_mode = get_custom_code_mode;
	}
	
	private String custom_app_brand_user_name;
	private String custom_app_brand_pass;

	public String getCustom_app_brand_user_name() {
		return custom_app_brand_user_name;
	}
	public void setCustom_app_brand_user_name(String custom_app_brand_user_name) {
		this.custom_app_brand_user_name = custom_app_brand_user_name;
	}
	public String getCustom_app_brand_pass() {
		return custom_app_brand_pass;
	}
	public void setCustom_app_brand_pass(String custom_app_brand_pass) {
		this.custom_app_brand_pass = custom_app_brand_pass;
	}

	
	
	
	

	
	
}
