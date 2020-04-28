package cn.wandingkeji.member.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
 * add by ws 0524
 * 会员积分明细
 */
@Setter
@Getter
@ToString
public class WdMemBonTrans extends BaseRowModel {
	/**
	 * 主键id
	 */
	private int id;
	/**
	 * 会员积分表主键
	 */
	private Integer bonus_id;
	/**
	 * 余额明细表主键id
	 */
	private Integer bal_trans_id;
	private Integer member_id;
	private Integer mid;
	private Integer sid;
	private Integer eid;
	private Timestamp trans_date;
	private Timestamp entry_date;
	private BigDecimal amount;
	private String order_id;
	private String order_item_id;//订单明细编号
	@ExcelProperty( value = "交易类型",index = 6)
	private String reason_id;//原因枚举
	private String comments;//备注
	private Timestamp update_stamp;
	@ExcelProperty( value = "交易时间",index = 4)
	private Timestamp creat_stamp;
	@ExcelProperty( value = "积分变动",index = 2)
	private BigDecimal bouns;
	private BigDecimal discount_amt; //打折的金额
	private String trans_type;
	private String pay_channel;
	@ExcelProperty( value = "订单状态",index = 5)
	private String status;
	@ExcelProperty( value = "账户积分",index = 3)
	private BigDecimal account_bouns;//账户的当前积分
	private BigDecimal account_balance;//账户的当前余额
	private String coupon_id;
	private BigDecimal coupon_amt;
	private BigDecimal bouns_deduction;//积分抵扣的金额

	private BigDecimal discount;//优惠金额
	private String order_type;
	private int parent_id;
	@ExcelProperty( value = "会员卡号",index = 1)
	private String account_num;
	@ExcelProperty( value = "会员名称",index = 0)
	private String account_name;
	@ExcelProperty( value = "交易门店",index = 7)
	private String store_name;

	
	
}
