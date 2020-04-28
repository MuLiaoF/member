package cn.wandingkeji.member.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
 * 会员账户表
 * add by ws 
 * 0524
 */
public class WdMemBalance {
	/**
	 *主键id
	 */
	private int id;
	private String member_id;
	private String user_code_id;
	private String card_id;
	private String status;
	private String account_name;
	private String account_num;
	private String account_pin;
	private String uom;
	private String org;
	private String owner_id;
	private Timestamp from_date;//生效时间
	private Timestamp thru_date;//失效时间
	private String level;
	private BigDecimal actual_balance;
	private BigDecimal available_balance;
	private BigDecimal account_bouns;
	private Timestamp creat_date;
	private Timestamp update_date;
	private BigDecimal donate_amount;
	private BigDecimal cum_trans_amt;//累计消费金额
	//最新消费时间
	private Timestamp payTimeLatest;
	//消费门店
	private int payStoreId;
	//消费门店
	private int payCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getUser_code_id() {
		return user_code_id;
	}

	public void setUser_code_id(String user_code_id) {
		this.user_code_id = user_code_id;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public String getAccount_pin() {
		return account_pin;
	}

	public void setAccount_pin(String account_pin) {
		this.account_pin = account_pin;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public Timestamp getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Timestamp from_date) {
		this.from_date = from_date;
	}

	public Timestamp getThru_date() {
		return thru_date;
	}

	public void setThru_date(Timestamp thru_date) {
		this.thru_date = thru_date;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public BigDecimal getActual_balance() {
		return actual_balance;
	}

	public void setActual_balance(BigDecimal actual_balance) {
		this.actual_balance = actual_balance;
	}

	public BigDecimal getAvailable_balance() {
		return available_balance;
	}

	public void setAvailable_balance(BigDecimal available_balance) {
		this.available_balance = available_balance;
	}

	public BigDecimal getAccount_bouns() {
		return account_bouns;
	}

	public void setAccount_bouns(BigDecimal account_bouns) {
		this.account_bouns = account_bouns;
	}

	public Timestamp getCreat_date() {
		return creat_date;
	}

	public void setCreat_date(Timestamp creat_date) {
		this.creat_date = creat_date;
	}

	public Timestamp getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}

	public BigDecimal getDonate_amount() {
		return donate_amount;
	}

	public void setDonate_amount(BigDecimal donate_amount) {
		this.donate_amount = donate_amount;
	}

	public BigDecimal getCum_trans_amt() {
		return cum_trans_amt;
	}

	public void setCum_trans_amt(BigDecimal cum_trans_amt) {
		this.cum_trans_amt = cum_trans_amt;
	}

	public Timestamp getPayTimeLatest() {
		return payTimeLatest;
	}

	public void setPayTimeLatest(Timestamp payTimeLatest) {
		this.payTimeLatest = payTimeLatest;
	}

	public int getPayStoreId() {
		return payStoreId;
	}

	public void setPayStoreId(int payStoreId) {
		this.payStoreId = payStoreId;
	}

	public int getPayCount() {
		return payCount;
	}

	public void setPayCount(int payCount) {
		this.payCount = payCount;
	}
}
