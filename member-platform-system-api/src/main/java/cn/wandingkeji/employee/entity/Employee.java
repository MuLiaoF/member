package cn.wandingkeji.employee.entity;

import lombok.*;

import java.sql.Timestamp;

/**
 * 终端实体
 * @author jing_huan
 *
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private  int  eid;
	private  int  sid;
	private  int  mid;
	/**
	 * 支付商户号
	 */
	private  String  merchant_no;
	private  String  pay_token;
	/**
	 * 支付终端号
	 */
	private  String  terminal_id;
	private  String  ename;
	private  String  reserve1;
	private  String  reserve2;
	/**
	 * 创建时间
	 */
	private  Timestamp create_time;
	/**
	 * 更新时间
	 */
	private  Timestamp  update_time;

}
