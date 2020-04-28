package cn.wandingkeji.card.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 会员卡商品表
 * @author wangsen
 *
 */
@Getter
@Setter
@ToString
public class WdCardGoods {
	private Integer id;//主键
	private Integer mid;//商户id
	private Integer sid;//门店id
	private Integer eid;//款台id
	private String card_id;//会员卡的card_id
	private String product_name;//商品名称
	private String small_url;//缩略图
	private String pic_url;//商品图
	private BigDecimal n_price;//现价
	private BigDecimal v_price;//会员价
	private BigDecimal o_price;//原价
	private Integer stock;//库存
	private String status;//状态（上架Y，下架N）
	private Integer sale_count;//真实销售数量
	private Integer base_count;//显示销售数量
	private String depict;//商品描述
	private String rule;//规则
	private Integer sort;//排序
	private String isBuy;//是否是付费;Y付费，N免费
	private Integer payRuleId;//付费卡规则
	private Timestamp creat_time;//创建时间
	private Timestamp update_time;//更新时间
	private Integer  group_storeId;//团购商城ID
	private String buy_read;//购买须知
	private Integer card_level_id;//会员卡等级编号
	private String card_level_name;//会员卡等级名称
	private String storeName;
	private String outStr;  //会员卡pos Or  Mini
	
	public WdCardGoods() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
