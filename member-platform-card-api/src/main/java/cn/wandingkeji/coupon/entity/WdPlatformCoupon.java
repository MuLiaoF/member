package cn.wandingkeji.coupon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 平台券实体
 * @author Administrator
 *
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WdPlatformCoupon  implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private int id;
	/**
	 * 代理id
	 */
	private Integer agent_id;
	/**
	 * 商户id
	 */
	private int mid;
	/**
	 * 门店编号
	 */
	private Integer sid;
	
	/**
	 * 公众号appid
	 */
	private String appid;
	/**
	 *卡券编号 
	 */
	private String card_id;
	/**
	 * 卡券类型
	 */
	private String card_type;
	/**
	 * 卡券标题
	 */
	private String title;
	/**
	 * 通道类型
	 */
	private String channel_type;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 是否分享
	 */
	private Integer can_share;
	/**
	 * 券数量
	 */
	private Integer quantity;
	/**
	 * 限领数量
	 */
	private Integer get_limit;
	/**
	 * 创建时间
	 */
	private Timestamp creat_time;
	/**
	 * 更新时间
	 */
	private Timestamp update_time;
	/**
	 * 卡券颜色
	 */
	private String color;
	/**
	 * logourl
	 */
	private String logo_url;
	/**
	 * 规则说明
	 */
	private String rolu_info;
	/**
	 * 第三方code码值(目前微信官方)
	 */
	private String third_card_id;
	/**
	 *
	 */
	private String depict;

	
	
}
