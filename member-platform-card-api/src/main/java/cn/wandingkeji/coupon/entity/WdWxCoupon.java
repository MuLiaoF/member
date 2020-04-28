package cn.wandingkeji.coupon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 
 * @author Administrator
 *
 * 微信官方券实体
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WdWxCoupon implements Serializable{
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
	
	private Integer fixed_term;//微信劵独有，自领取后多少天内有效
	private Integer fixed_begin_term;//微信劵独有，表示自领取后多少天开始生效
	
	private String loc_logo_url;
	private String loc_bac_url;
	
	private String old_mem_bind_name;//是否支持绑定老会员
	private String old_mem_bind_url;
	private String supply_old_bind;
	
	private BigDecimal cash_least_cost;//代金券专用，表示起用金额
	private BigDecimal cash_reduce_cost;//代金券专用，表示减免金额

	private String isLevel;
	private String card_id;
	
	private int is_phone_card_number;
	private int status;      //当前用户的券的状态
}
