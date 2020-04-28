package cn.wandingkeji.member.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
 * add by ws 0524
 * 会员账户明细
 */
public class WdMemAccTrans {

	private int acc_trans_id;
	private String account_id;
	private String member_id;
	private Timestamp trans_date;
	private Timestamp entry_date;
	private BigDecimal amount;
	private String order_id;
	private String order_item_id;//订单明细编号
	private String reason_id;//原因枚举
	private String comments;//备注
	private Timestamp update_stamp;
	private Timestamp creat_stamp;
	private BigDecimal bouns;
	private BigDecimal discount_amt; //打折的金额
	private String trans_type;
	private String pay_channel;
	private String status;
	private BigDecimal account_bouns;//账户的当前积分
	private BigDecimal account_balance;//账户的当前余额
	private String coupon_id;
	private BigDecimal coupon_amt;
	private BigDecimal bouns_deduction;//积分抵扣的金额
	private int mid;
	private String sid;
	private String eid;
	private BigDecimal discount;//优惠金额
	private String order_type;
	private int parent_id;

	
	
	
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public BigDecimal getAccount_bouns() {
		return account_bouns;
	}
	public void setAccount_bouns(BigDecimal account_bouns) {
		this.account_bouns = account_bouns;
	}
	public BigDecimal getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(BigDecimal account_balance) {
		this.account_balance = account_balance;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
	public BigDecimal getCoupon_amt() {
		return coupon_amt;
	}
	public void setCoupon_amt(BigDecimal coupon_amt) {
		this.coupon_amt = coupon_amt;
	}
	public BigDecimal getBouns_deduction() {
		return bouns_deduction;
	}
	public void setBouns_deduction(BigDecimal bouns_deduction) {
		this.bouns_deduction = bouns_deduction;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getBouns() {
		return bouns;
	}
	public void setBouns(BigDecimal bouns) {
		this.bouns = bouns;
	}
	public BigDecimal getDiscount_amt() {
		return discount_amt;
	}
	public void setDiscount_amt(BigDecimal discount_amt) {
		this.discount_amt = discount_amt;
	}
	public String getTrans_type() {
		return trans_type;
	}
	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}
	public String getPay_channel() {
		return pay_channel;
	}
	public void setPay_channel(String pay_channel) {
		this.pay_channel = pay_channel;
	}
	public int getAcc_trans_id() {
		return acc_trans_id;
	}
	public void setAcc_trans_id(int acc_trans_id) {
		this.acc_trans_id = acc_trans_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Timestamp getTrans_date() {
		return trans_date;
	}
	public void setTrans_date(Timestamp trans_date) {
		this.trans_date = trans_date;
	}
	public Timestamp getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(Timestamp entry_date) {
		this.entry_date = entry_date;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(String order_item_id) {
		this.order_item_id = order_item_id;
	}
	public String getReason_id() {
		return reason_id;
	}
	public void setReason_id(String reason_id) {
		this.reason_id = reason_id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Timestamp getUpdate_stamp() {
		return update_stamp;
	}
	public void setUpdate_stamp(Timestamp update_stamp) {
		this.update_stamp = update_stamp;
	}
	public Timestamp getCreat_stamp() {
		return creat_stamp;
	}
	public void setCreat_stamp(Timestamp creat_stamp) {
		this.creat_stamp = creat_stamp;
	}
	
	
	
	
}
