package cn.wandingkeji.coupon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author Administrator
 *
 * 次卡明细实体(核销记录)
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WdFrequencyTrans implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private int id;
	
	/**
	 * 使用时间
	 */
	private Timestamp use_time;
	
	/**
	 * 记录类型
	 */
	private String tran_type;
	/**
	 * 次卡编号
	 */
	private String card_id;
	/**
	 * 领取人编号
	 */
	private String code;
	/**
	 * 使用人编号
	 */
	private String openid;
	
	private String openid_type;
	/**
	 * 使用次数()
	 */
	private int use_total;
	/**
	 * 剩余次数()
	 */
	private int surplus_total;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private Timestamp creat_time;
	/**
	 * 更新时间
	 */
	private Timestamp update_time;
	/**
	 * 备注
	 */
	private String reserve;

	/**
	 * 核销门店
	 */
	private String sid;

}
