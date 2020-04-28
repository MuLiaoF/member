package cn.wandingkeji.common.base.wx.mp.protocol.memberCard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 修改会员卡的baseInfo
 */
public class UpdateCardBaseInfo {
    private String title;
    private String logo_url;
    private String notice;
    private String description;
    private String service_phone;
    private String color;
    private List<String> location_id_list;
    private boolean use_all_locations;
    private String center_title;
    private String center_sub_title;
    private String center_url;
    private String custom_url_name;
    private String custom_url;
    private String custom_url_sub_title;
    private String promotion_url_name;
    private String promotion_url;
    private String promotion_url_sub_title;

    private String pay_info;
    private String swipe_card;//刷卡功能结构体
    /*	private boolean is_swipe_card=false;
        private boolean is_pay_and_qrcode=false;*/
    private int get_limit;
    private boolean can_share;
    private boolean can_give_friend;
    private String code_type;

    Map<String, Object> date_info;

//	private String custom_app_brand_user_name;
//	private String custom_app_brand_pass;
//	
//
//	public String getCustom_app_brand_user_name() {
//		return custom_app_brand_user_name;
//	}
//	public void setCustom_app_brand_user_name(String custom_app_brand_user_name) {
//		this.custom_app_brand_user_name = custom_app_brand_user_name;
//	}
//	public String getCustom_app_brand_pass() {
//		return custom_app_brand_pass;
//	}
//	public void setCustom_app_brand_pass(String custom_app_brand_pass) {
//		this.custom_app_brand_pass = custom_app_brand_pass;
//	}

    /**
     * 永久有效
     */
    public UpdateCardBaseInfo setDate_info() {
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("type", "DATE_TYPE_PERMANENT");
        this.date_info = hashMap;
        return this;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
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

    public String getPay_info() {
        return pay_info;
    }

    public void setPay_info(String pay_info) {
        this.pay_info = pay_info;
    }

    public String getSwipe_card() {
        return swipe_card;
    }

    public void setSwipe_card(String swipe_card) {
        this.swipe_card = swipe_card;
    }
	/*public boolean isIs_swipe_card() {
		return is_swipe_card;
	}
	public void setIs_swipe_card(boolean is_swipe_card) {
		this.is_swipe_card = is_swipe_card;
	}
	public boolean isIs_pay_and_qrcode() {
		return is_pay_and_qrcode;
	}
	public void setIs_pay_and_qrcode(boolean is_pay_and_qrcode) {
		this.is_pay_and_qrcode = is_pay_and_qrcode;
	}
	*/


}
