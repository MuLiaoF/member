package cn.wandingkeji.member.entity;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WdMember  {

	private int id;
	private int mid;
	private String card_id;
	private String card_no;
	private String card_barcode;
	private int bonus;//积分
	
	private BigDecimal balance;//余额
	private BigDecimal all_paymoney;
	private int type;
	private String name;
	private String phone;
	private String wx_name;
	private String wx_pic;
	private String sex;
	private String email;
	private String address;
	private String addtime;
	private int expenses_total;
	private int education;
	private int industry;
	private int year;
	private int month;
	private int day;
	private int salary;
	private String likes;
	private int grade_id;
	private String grade_name;
	private int msg_nub;//数据类型
	private String openid;
	private int store_id;
	private String store_name;
	private int province_code;
	private int city_code;
	private String update_paytime;
	private int pay_nub;
	private String tags;
	private char pw;
	private String status;
	private String outerid;
	private String idcard;
	private String career;
	private int has_active;
	
	private String level;
	private String level_name;
	private Timestamp creat_time;
	
	private String password;
	private String salt;
	private String loc_status;
	//add by wjl person表主键(2017-12-22)
	private Integer person_id;
	
	private String mini_appid;
	private String mini_openid;
	
	private String unionid;

	private String empId;
	private String reserve1;
	private String reserve2;
	private String reserve3;

}
