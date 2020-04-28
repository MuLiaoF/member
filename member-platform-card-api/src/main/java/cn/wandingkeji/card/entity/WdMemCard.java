package cn.wandingkeji.card.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/*
 * add by ws
 *  20190515
 *  会员卡表
 */ 
public class WdMemCard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int agent_id;
	private int mid;
	private int sid;
	private int eid;
	private String appid;   
	private String card_type;   //会员卡类型
	private String title;       //卡券名
	private String wxcard_id;     //微信返回的card_id
	private String status;      //当前用户的会员卡状态，  *****user_card_status   
	private int can_share;    //卡券领取页面是否可分享，默认为true 
	private int quantity;    //卡券库存的数量
	private int get_limit; //每人可领券的数量限制
	private Timestamp creat_time;
	private Timestamp update_time;
	private String location_id_list;//text  门店位置ID。

	private int cost_money_unit;   //消费金额。以分为单位。
	private int increase_bonus;  //对应增加的积分
	private int max_increase_bonus;  //用户单次可获取的积分上限。    
	private int init_increase_bonus;   //初始设置积分
	private int cost_bonus_unit;   //每使用5积分。
	private int reduce_money;   //抵扣xx元，（这里以分为单位）
	private int least_money_to_use_bonus;  //抵扣条件，满xx元（这里以分为单位）可用
	private int max_reduce_bonus;  //抵扣条件，单笔最多使用xx积分
	
	private String logo_url;   //卡券的商户logo
	private String brand_name;  //商户名字,
	private String background_pic_url;  //商家自定义会员卡背景图，须 先调用上传图片接口将背景图上传至CDN
	private String color;  //券颜色
	private String date_info;  //使用日期，有效期的信息。 
	private String time_limit; //使用时段限制， 
	private String notice;   //卡券使用提醒
	private float discount;   //折扣，该会员卡享受的折扣优惠,填10就是九折。
	private int supply_bonus;   //显示积分
	private int supply_discount;  //显示折扣
	private int supply_discount_grade;  //显示折扣等级
	private String prerogative;//text  会员卡特权说明。
	private String description;//text   卡券使用说明
	private String text_image_list;//text  图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表
	private String service_phone;   //客服电话   
	private String business_service;   //商家服务类型：
	private int is_pay;   //是否设置该会员卡中部的按钮同时支持微信支付刷卡和会员卡二维码   ****is_pay_and_qrcode
	private String center_title;  //卡券中部居中的按钮，仅在卡券激活后且可用状态时显示  
	private String center_sub_title; //****意义不明
	private String center_url;  //顶部居中的url，仅在卡券激活后且可用状态时显示              
	private int auto_activate =0;  //自动激活
	private int wx_activate;  //一键开卡
	private String activate_url;  //激活会员卡的url。  
	private String activate_required; //激活会员卡必须传入的属性
	private String activate_norequired; //激活会员卡非必须传入的属性
	private String custom_field1;   //自定义会员信息类目名
	
	private String reserve1;    //

	private String bonus_url;    //设置跳转外链查看积分详情。
	private String custom_field2;  //自定义会员信息类目
	private String custom_field3;    //自定义会员信息类目
	private String custom_url_name;  //自定义跳转外链的入口名字。
	private String custom_url_sub_title;  //显示在入口右侧的提示语。  
	private String custom_url;     //自定义跳转的URL。
	private String promotion_url_name;     //营销场景的自定义入口名称。
	private String promotion_url_sub_title;   //显示在营销入口右侧的提示语。
	private String promotion_url;    //入口跳转外链的地址链接。
	private String custom_cell1;   //自定义会员信息类目，会员卡激活后显示。

	private int use_custom_code;   //通常自有优惠码系统的开发者选择自定义Code码，
	private String custom_code_info;     //****意义不明
	private int need_push_on_view;  //填写true为用户点击进入会员卡时推送事件，默认为false。
	private String get_custom_code_mode;  //****意义不明
	private int use_all_locations;  //会员卡是否支持全部门店
	private int supply_balance;   //是否支持储值，填写true或false
	private String balance_url;  //设置跳转外链查看余额详情。
	private Timestamp begin_time;   //type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。  ****begin_timestamp 
	private Timestamp end_time;    //type为DATE_TYPE_FIX_TIME_RANGE时专用，表示结束时间。  ****end_timestamp 
	private String code_type;   //CODE_TYPE_QRCODE
	private int can_give_friend;
	private String name_type;
	private int payment_is_mem;//是否支持支付即会员
	private String rule_info;
	private int defaults;//默认
	private String rule_id;//支付即会员规则id
	
	private int fixed_term;//微信劵独有，自领取后多少天内有效
	private int fixed_begin_term;//微信劵独有，表示自领取后多少天开始生效
	private String loc_logo_url;
	private String loc_bac_url;
	
	private String old_mem_bind_name;//是否支持绑定老会员
	private String old_mem_bind_url;
	private String supply_old_bind;
	
	private BigDecimal cash_least_cost;//代金券专用，表示起用金额
	private BigDecimal cash_reduce_cost;//代金券专用，表示减免金额

	private String isLevel;

	
	public String getIsLevel() {
		return isLevel;
	}
	public void setIsLevel(String isLevel) {
		this.isLevel = isLevel;
	}
	public BigDecimal getCash_least_cost() {
		return cash_least_cost;
	}
	public void setCash_least_cost(BigDecimal cash_least_cost) {
		this.cash_least_cost = cash_least_cost;
	}
	public BigDecimal getCash_reduce_cost() {
		return cash_reduce_cost;
	}
	public void setCash_reduce_cost(BigDecimal cash_reduce_cost) {
		this.cash_reduce_cost = cash_reduce_cost;
	}
	public String getOld_mem_bind_name() {
		return old_mem_bind_name;
	}
	public void setOld_mem_bind_name(String old_mem_bind_name) {
		this.old_mem_bind_name = old_mem_bind_name;
	}
	public String getOld_mem_bind_url() {
		return old_mem_bind_url;
	}
	public void setOld_mem_bind_url(String old_mem_bind_url) {
		this.old_mem_bind_url = old_mem_bind_url;
	}
	public String getSupply_old_bind() {
		return supply_old_bind;
	}
	public void setSupply_old_bind(String supply_old_bind) {
		this.supply_old_bind = supply_old_bind;
	}
	public String getLoc_bac_url() {
		return loc_bac_url;
	}
	public void setLoc_bac_url(String loc_bac_url) {
		this.loc_bac_url = loc_bac_url;
	}
	public String getLoc_logo_url() {
		return loc_logo_url;
	}
	public void setLoc_logo_url(String loc_logo_url) {
		this.loc_logo_url = loc_logo_url;
	}
	public int getFixed_term() {
		return fixed_term;
	}
	public void setFixed_term(int fixed_term) {
		this.fixed_term = fixed_term;
	}
	public int getFixed_begin_term() {
		return fixed_begin_term;
	}
	public void setFixed_begin_term(int fixed_begin_term) {
		this.fixed_begin_term = fixed_begin_term;
	}
	public String getRule_id() {
		return rule_id;
	}
	public void setRule_id(String rule_id) {
		this.rule_id = rule_id;
	}
	public int getDefaults() {
		return defaults;
	}
	public void setDefaults(int defaults) {
		this.defaults = defaults;
	}
	public String getRule_info() {
		return rule_info;
	}
	public void setRule_info(String rule_info) {
		this.rule_info = rule_info;
	}
	public int getPayment_is_mem() {
		return payment_is_mem;
	}
	public void setPayment_is_mem(int payment_is_mem) {
		this.payment_is_mem = payment_is_mem;
	}
	public String getName_type() {
		return name_type;
	}
	public void setName_type(String name_type) {
		this.name_type = name_type;
	}

	public int getCan_give_friend() {
		return can_give_friend;
	}
	public void setCan_give_friend(int can_give_friend) {
		this.can_give_friend = can_give_friend;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getWxcard_id() {
		return wxcard_id;
	}
	public void setWxcard_id(String wxcard_id) {
		this.wxcard_id = wxcard_id;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCan_share() {
		return can_share;
	}
	public void setCan_share(int can_share) {
		this.can_share = can_share;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getGet_limit() {
		return get_limit;
	}
	public void setGet_limit(int get_limit) {
		this.get_limit = get_limit;
	}

	public Timestamp getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(Timestamp creat_time) {
		this.creat_time = creat_time;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public String getLocation_id_list() {
		return location_id_list;
	}
	public void setLocation_id_list(String location_id_list) {
		this.location_id_list = location_id_list;
	}
	


	public int getCost_money_unit() {
		return cost_money_unit;
	}
	public void setCost_money_unit(int cost_money_unit) {
		this.cost_money_unit = cost_money_unit;
	}
	public int getIncrease_bonus() {
		return increase_bonus;
	}
	public void setIncrease_bonus(int increase_bonus) {
		this.increase_bonus = increase_bonus;
	}
	public int getMax_increase_bonus() {
		return max_increase_bonus;
	}
	public void setMax_increase_bonus(int max_increase_bonus) {
		this.max_increase_bonus = max_increase_bonus;
	}
	public int getInit_increase_bonus() {
		return init_increase_bonus;
	}
	public void setInit_increase_bonus(int init_increase_bonus) {
		this.init_increase_bonus = init_increase_bonus;
	}
	public int getCost_bonus_unit() {
		return cost_bonus_unit;
	}
	public void setCost_bonus_unit(int cost_bonus_unit) {
		this.cost_bonus_unit = cost_bonus_unit;
	}
	public int getReduce_money() {
		return reduce_money;
	}
	public void setReduce_money(int reduce_money) {
		this.reduce_money = reduce_money;
	}
	public int getLeast_money_to_use_bonus() {
		return least_money_to_use_bonus;
	}
	public void setLeast_money_to_use_bonus(int least_money_to_use_bonus) {
		this.least_money_to_use_bonus = least_money_to_use_bonus;
	}
	public int getMax_reduce_bonus() {
		return max_reduce_bonus;
	}
	public void setMax_reduce_bonus(int max_reduce_bonus) {
		this.max_reduce_bonus = max_reduce_bonus;
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

	public String getBackground_pic_url() {
		return background_pic_url;
	}
	public void setBackground_pic_url(String background_pic_url) {
		this.background_pic_url = background_pic_url;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDate_info() {
		return date_info;
	}
	public void setDate_info(String date_info) {
		this.date_info = date_info;
	}
	public String getTime_limit() {
		return time_limit;
	}
	public void setTime_limit(String time_limit) {
		this.time_limit = time_limit;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getSupply_bonus() {
		return supply_bonus;
	}
	public void setSupply_bonus(int supply_bonus) {
		this.supply_bonus = supply_bonus;
	}
	public int getSupply_discount() {
		return supply_discount;
	}
	public void setSupply_discount(int supply_discount) {
		this.supply_discount = supply_discount;
	}
	public int getSupply_discount_grade() {
		return supply_discount_grade;
	}
	public void setSupply_discount_grade(int supply_discount_grade) {
		this.supply_discount_grade = supply_discount_grade;
	}
	public String getPrerogative() {
		return prerogative;
	}
	public void setPrerogative(String prerogative) {
		this.prerogative = prerogative;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getText_image_list() {
		return text_image_list;
	}
	public void setText_image_list(String text_image_list) {
		this.text_image_list = text_image_list;
	}
	public String getService_phone() {
		return service_phone;
	}
	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}
	public String getBusiness_service() {
		return business_service;
	}
	public void setBusiness_service(String business_service) {
		this.business_service = business_service;
	}

	public int getIs_pay() {
		return is_pay;
	}
	public void setIs_pay(int is_pay) {
		this.is_pay = is_pay;
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
	public int getAuto_activate() {
		return auto_activate;
	}
	public void setAuto_activate(int auto_activate) {
		this.auto_activate = auto_activate;
	}
	public int getWx_activate() {
		return wx_activate;
	}
	public void setWx_activate(int wx_activate) {
		this.wx_activate = wx_activate;
	}
	public String getActivate_url() {
		return activate_url;
	}
	public void setActivate_url(String activate_url) {
		this.activate_url = activate_url;
	}
	public String getActivate_required() {
		return activate_required;
	}
	public void setActivate_required(String activate_required) {
		this.activate_required = activate_required;
	}
	public String getActivate_norequired() {
		return activate_norequired;
	}
	public void setActivate_norequired(String activate_norequired) {
		this.activate_norequired = activate_norequired;
	}

	public String getBonus_url() {
		return bonus_url;
	}
	public void setBonus_url(String bonus_url) {
		this.bonus_url = bonus_url;
	}
	public String getCustom_field2() {
		return custom_field2;
	}
	public void setCustom_field2(String custom_field2) {
		this.custom_field2 = custom_field2;
	}
	public String getCustom_field3() {
		return custom_field3;
	}
	public void setCustom_field3(String custom_field3) {
		this.custom_field3 = custom_field3;
	}
	public String getCustom_url_name() {
		return custom_url_name;
	}
	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}
	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}
	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}
	public String getCustom_url() {
		return custom_url;
	}
	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}
	public String getPromotion_url_name() {
		return promotion_url_name;
	}
	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}
	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}
	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}
	public String getPromotion_url() {
		return promotion_url;
	}
	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}

	public int getUse_custom_code() {
		return use_custom_code;
	}
	public void setUse_custom_code(int use_custom_code) {
		this.use_custom_code = use_custom_code;
	}
	public String getCustom_code_info() {
		return custom_code_info;
	}
	public void setCustom_code_info(String custom_code_info) {
		this.custom_code_info = custom_code_info;
	}
	public int getNeed_push_on_view() {
		return need_push_on_view;
	}
	public void setNeed_push_on_view(int need_push_on_view) {
		this.need_push_on_view = need_push_on_view;
	}
	public String getGet_custom_code_mode() {
		return get_custom_code_mode;
	}
	public void setGet_custom_code_mode(String get_custom_code_mode) {
		this.get_custom_code_mode = get_custom_code_mode;
	}
	public int getUse_all_locations() {
		return use_all_locations;
	}
	public void setUse_all_locations(int use_all_locations) {
		this.use_all_locations = use_all_locations;
	}
	public int getSupply_balance() {
		return supply_balance;
	}
	public void setSupply_balance(int supply_balance) {
		this.supply_balance = supply_balance;
	}
	public String getBalance_url() {
		return balance_url;
	}
	public void setBalance_url(String balance_url) {
		this.balance_url = balance_url;
	}



	public String getCode_type() {
		return code_type;
	}
	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}
	public String getCustom_field1() {
		return custom_field1;
	}
	public void setCustom_field1(String custom_field1) {
		this.custom_field1 = custom_field1;
	}
	public String getCustom_cell1() {
		return custom_cell1;
	}
	public void setCustom_cell1(String custom_cell1) {
		this.custom_cell1 = custom_cell1;
	}
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	public Timestamp getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(Timestamp begin_time) {
		this.begin_time = begin_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}

	public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if (obj != null) {
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
	
	
	
	
	
	
}
