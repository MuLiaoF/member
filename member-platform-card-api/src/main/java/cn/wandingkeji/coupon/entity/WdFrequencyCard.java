package cn.wandingkeji.coupon.entity;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 
 * @author Administrator
 *
 * 计次卡属性实体
 */
@ToString
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WdFrequencyCard implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 卡卷编号(与平台劵表中的计次卡关联)
	 */
	private String card_id;
	/**
	 * 卡卷名称
	 */
	private String coupon_name;
	
	
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
	 * 每天使用的次数
	 */
	private Integer numDay;
	/**
	 * 每次核销的数量
	 */
	private Integer numWriteOff;
	/**
	 * 次卡初始次数
	 */
	private Integer initialTotal;
	private Integer surplus_total;
	/**
	 * 次卡头像url地址
	 */
	private String avatarUrl;
	/**
	 * 使用规则(将规则以json存储)
	 */
	private String role;
	
	private String use_all_locations;
	
	private Integer store_id;
	
	
}
