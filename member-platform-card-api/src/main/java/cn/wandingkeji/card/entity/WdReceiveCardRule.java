package cn.wandingkeji.card.entity;
/*
 * 支付领卡规则
 * add by ws
 * 20190603
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@ToString
public class WdReceiveCardRule {

	private int id;
	private int mid;
	private int sid;
	private String rule_name;
	private String wx_card_id;
	private String type;
	private String status;
	private String wd_coupon_card_id;
	private Date begin_time;
	private Date end_time;
	private String reserve1;
	private String reserve2;
	private Timestamp create_time;
	
}
