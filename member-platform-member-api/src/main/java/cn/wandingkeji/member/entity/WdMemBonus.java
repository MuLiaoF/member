package cn.wandingkeji.member.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
 * 会员积分表
 * add by ws 
 * 0524
 */
@Setter
@Getter
@ToString
public class WdMemBonus {
	/**
	 * 主键id
	 */
	private int id;
	/**
	 * 会员主键id
	 */
	private String member_id;
	/**
	 * code序列号
	 */
	private String user_code_id;
	/**
	 * 卡的card_id
	 */
	private String card_id;
	private String status;
	private String account_name;
	private String account_num;
	private String account_pin;
	private String uom;
	private String org;
	private String owner_id;
	private Timestamp from_date;//生效时间
	private Timestamp thru_date;//失效时间
	private String level;
	private BigDecimal actual_balance;
	private BigDecimal available_balance;
	/**
	 * 当前剩余积分
	 */
	private BigDecimal account_bouns;
	private Timestamp creat_date;
	private Timestamp update_date;
	private BigDecimal cum_trans_amt;//累计消费金额
	

	
}
