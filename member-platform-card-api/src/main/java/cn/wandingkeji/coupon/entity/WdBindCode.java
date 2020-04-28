package cn.wandingkeji.coupon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 
 * 用于绑定核销时code码
 * @author jing_huan
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WdBindCode {
	private int id;
	/**
	 * 商户id
	 */
	private int  mid;
	/**
	 * 计次卡的code码
	 */
	private String code;
	/**
	 * md5加密生成平台唯一码(具体规则待定)
	 */
	private String mdCode;
	/**
	 * 计次卡要核销的次数
	 */
	private int frequency;
	
	private int effectiveTime;
	/**
	 * 是否失效
	 * 0 已失效  1 有效
	 */
	private String status;
	private String unionid;
	private String openid;
	/**
	 * 类型:MINI小程序
	 *     MP公众号
	 */
	private String openid_type;
	/**
	 * 备用字段1
	 */
	private String reserve1;
	/**
	 * 备用字段2
	 */
	private String reserve2;
	/**
	 * 创建时间
	 */
	private Timestamp gmt_create;
	/**
	 * 更新时间
	 */
	private Timestamp gmt_modified;
	
}
