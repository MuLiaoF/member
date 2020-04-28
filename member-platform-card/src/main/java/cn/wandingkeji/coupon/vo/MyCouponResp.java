package cn.wandingkeji.coupon.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Setter
@Getter
@ToString
public class MyCouponResp {
	private Integer id;
	private Integer mid;
	private String card_id;
	private String code;
	private String open_id;
	private String status;
	private Timestamp create_time;
	//有效期起始时间
	private Timestamp begin_time;
	//有效期结束时间
	private Timestamp end_time;
	//1为固定日期  2 为多少天起,多少天内有效
	private String date_info;
	//为多少天起
	private Integer fixed_begin_term;
	//多少天内有效
	private Integer fixed_term;
	private String title;
	private String logo_url;
	private String rolu_info;
}
