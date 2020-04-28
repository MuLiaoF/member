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
 * 会员账户明细
 */
@Setter
@Getter
@ToString
public class WdMemBalTrans extends BaseRowModel {
	private int id;
	private Integer mid;
	private Integer sid;
	private Integer eid;
	private Integer balance_id;
	private Integer member_id;

	private String employee_no;

	private Timestamp trans_date;
	private Timestamp entry_date;
	@ExcelProperty( value = "交易金额",index = 2)
	private BigDecimal amount;
	private String order_id;
	private String order_item_id;//订单明细编号
	@ExcelProperty( value = "交易类型",index = 6)
	private String reason_id;//原因枚举
	private String comments;//备注
	private Timestamp update_stamp;
	@ExcelProperty( value = "交易时间",index = 4)
	private Timestamp creat_stamp;
	private BigDecimal bouns;
	private BigDecimal discount_amt; //打折的金额
	private String trans_type;
	private String pay_channel;
	@ExcelProperty( value = "订单状态",index = 5)
	private String status;
	private BigDecimal account_bouns;//账户的当前积分
	@ExcelProperty( value = "账户余额",index = 3)
	private BigDecimal account_balance;//账户的当前余额
	private String coupon_id;
	private BigDecimal coupon_amt;
	private BigDecimal bouns_deduction;//积分抵扣的金额
	
	private BigDecimal discount;//优惠金额
	private String order_type;
	private Integer parent_id;

	@ExcelProperty( value = "会员卡号",index = 1)
	private String account_num;
	@ExcelProperty( value = "会员姓名",index = 0)
	private String account_name;
	@ExcelProperty( value = "交易门店",index = 7)
	private String store_name;

	/**
	 * 账户当前赠送金额
	 */
	private BigDecimal account_donate;

}


