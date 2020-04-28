package cn.wandingkeji.common.base.wx.mp.protocol.memberCard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 */
public class BaseInfo {


	public String getLogo_url() {
		return logo_url;
	}
	public BaseInfo setLogo_url(String logo_url) {
		this.logo_url = logo_url;
		return this;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public BaseInfo setBrand_name(String brand_name) {
		this.brand_name = brand_name;
		return this;
	}
	public String getCode_type() {
		return code_type;
	}
	public BaseInfo setCode_type(String code_type) {
		this.code_type = code_type;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public BaseInfo setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getColor() {
		return color;
	}
	public BaseInfo setColor(String color) {
		this.color = color;
		return this;
	}
	public String getNotice() {
		return notice;
	}
	public BaseInfo setNotice(String notice) {
		this.notice = notice;
		return this;
	}
	public String getService_phone() {
		return service_phone;
	}
	public BaseInfo setService_phone(String service_phone) {
		this.service_phone = service_phone;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public BaseInfo setDescription(String description) {
		this.description = description;
		return this;
	}
	public int getGet_limit() {
		return get_limit;
	}
	public BaseInfo setGet_limit(int get_limit) {
		this.get_limit = get_limit;
		return this;
	}
	public boolean isUse_custom_code() {
		return use_custom_code;
	}
	public BaseInfo setUse_custom_code(boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
		return this;
	}
	public boolean isCan_give_friend() {
		return can_give_friend;
	}
	public BaseInfo setCan_give_friend(boolean can_give_friend) {
		this.can_give_friend = can_give_friend;
		return this;
	}
	public String getCustom_url_name() {
		return custom_url_name;
	}
	public BaseInfo setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
		return this;
	}
	public String getCustom_url() {
		return custom_url;
	}
	public BaseInfo setCustom_url(String custom_url) {
		this.custom_url = custom_url;
		return this;
	}
	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}
	public BaseInfo setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
		return this;
	}
	public String getPromotion_url_name() {
		return promotion_url_name;
	}
	public BaseInfo setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
		return this;
	}
	public String getPromotion_url() {
		return promotion_url;
	}
	public BaseInfo setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
		return this;
	}
	public boolean isNeed_push_on_view() {
		return need_push_on_view;
	}
	public BaseInfo setNeed_push_on_view(boolean need_push_on_view) {
		this.need_push_on_view = need_push_on_view;
		return this;
	}
	
	public List<String> getLocation_id_list() {
		return location_id_list;
	}
	public BaseInfo setLocation_id_list(List<String> location_id_list) {
		this.location_id_list = location_id_list;
		return this;
	}
	public Map<String, Object> getDate_info() {
		return date_info;
	}
	public BaseInfo setDate_info(Map<String, Object> date_info) {
		this.date_info = date_info;
		return this;
	}
	/**
	 * 永久有效
	 */
	public BaseInfo setDate_info() {
		Map<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("type","DATE_TYPE_PERMANENT");
		this.date_info = hashMap;
		return this;
	}

	public Map<String, Object> getSku() {
		return sku;
	}
	public BaseInfo setSku(Map<String, Object> sku) {
		this.sku = sku;
		return this;
	}
	public BaseInfo setSku(int quantity ) {
		Map<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("quantity",new  Integer(quantity));
		this.sku = hashMap;
		return this;
	}
	
	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}
	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}

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
	private boolean can_give_friend;
	private String custom_url_name;
	private String custom_url;
	private String custom_url_sub_title;
	private String promotion_url_name;
	private String promotion_url;
	private String promotion_url_sub_title;
	private boolean need_push_on_view;

	private List<String> location_id_list;
	
	Map<String,Object> date_info;
	Map<String,Object> sku;
	
	//add by jfr
//	Map<String,Object> pay_info;

	
	/*
	 * add by ws 20170505
	 */
	private String use_limit;
	private boolean bind_openid;
	private boolean can_share;
	private String center_title;
	private String center_sub_title;
	private String center_url;
	private String source;
	
	//add by ws 20170506
	private List<String> mchid_list;

	public String getUse_limit() {
		return use_limit;
	}
	public void setUse_limit(String use_limit) {
		this.use_limit = use_limit;
	}
	public boolean isBind_openid() {
		return bind_openid;
	}
	public void setBind_openid(boolean bind_openid) {
		this.bind_openid = bind_openid;
	}
	public boolean isCan_share() {
		return can_share;
	}
	public void setCan_share(boolean can_share) {
		this.can_share = can_share;
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public List<String> getMchid_list() {
		return mchid_list;
	}
	public void setMchid_list(List<String> mchid_list) {
		this.mchid_list = mchid_list;
	}
	
	private String begin_time;
	private String end_time;

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
	//add by 0508
	private String status;
	private String create_time;
	private String update_time;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	
	

	

	//add by ws0515
	
	private List<String> area_code_list;
	private int discount;
	private AdvancedInfo advanced_info;


	public List<String> getArea_code_list() {
		return area_code_list;
	}
	public void setArea_code_list(List<String> area_code_list) {
		this.area_code_list = area_code_list;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public AdvancedInfo getAdvanced_info() {
		return advanced_info;
	}
	public void setAdvanced_info(AdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
	}
	
	
	

	
	
}
