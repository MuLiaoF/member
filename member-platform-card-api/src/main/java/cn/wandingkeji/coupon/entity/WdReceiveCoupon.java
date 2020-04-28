package cn.wandingkeji.coupon.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * 领券记录表(微信官方券)
 * @author jing_huan
 *
 */
@ToString
@Setter
@Getter
@Data
public class WdReceiveCoupon {

	private int id;
	private int mid;
	private String card_id;
	private String code;
	private String open_id;
	private String is_give_by_friend;
	private String friend_open_id;
	private String outer_str;
	private Timestamp create_time;
	private String status;
	private Timestamp start_time;
	private Timestamp end_time;
	private Timestamp update_time;
	private String logo_url;
	private String title;
	private String description;
	private String store_name;
	private String check_openid;
	private String consume_source;
	//add by ws 20190416 核销时间
	private Timestamp use_time;
	private String unionid;
	//add by ws 20191022
	private String order_id;


	
	
}
