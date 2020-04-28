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
 * 领取计次卡实体
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WdReceiveFrequency  implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private int id;
	/**
	 * 商户编号
	 */
	private int mid;
	private int sid;
	/**
	 * 卡卷编号
	 */
	private String card_id;
	/**
	 * 领取code码
	 */
	private String code;
	/**
	 * 领取人
	 */
	private String openid;
	/**
	 * 类型(小程序 , 会员卡[小程序页面跳转,卡包,公众号])
	 */
	private String openid_type;
	/**
	 * 会员编号
	 */
	private int mem_id;
	/**
	 * 初始次数
	 */
	private int can_use_total;
	/**
	 * 剩余可使用次数
	 */
	private int surplus_total;
	/**
	 * 创建时间
	 */
	private Timestamp creat_time;
	/**
	 * 更新时间
	 */
	private Timestamp update_time;
	
	private String store_name;
	/**
	 * 备注
	 */
	private String reserve;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 次卡名称
	 */
	private String card_name;
	

	
}
