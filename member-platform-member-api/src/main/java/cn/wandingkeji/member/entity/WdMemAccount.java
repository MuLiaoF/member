package cn.wandingkeji.member.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
 * 会员账户表
 * add by ws 
 * 0524
 */
public class WdMemAccount {

	private int account_id;
	private String account_type;
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
	private BigDecimal cum_trans_amt;//累计消费金额
	
	
	public BigDecimal getCum_trans_amt() {
		return cum_trans_amt;
	}
	public void setCum_trans_amt(BigDecimal cum_trans_amt) {
		this.cum_trans_amt = cum_trans_amt;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
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
	@Override
	public String toString() {
		return "WdMemAccount [account_type=" + account_type + ", member_id=" + member_id + ", user_code_id="
				+ user_code_id + ", card_id=" + card_id + ", status=" + status + ", account_name=" + account_name
				+ ", account_num=" + account_num + ", account_pin=" + account_pin + ", uom=" + uom + ", org=" + org
				+ ", owner_id=" + owner_id + ", from_date=" + from_date + ", thru_date=" + thru_date + ", level="
				+ level + ", actual_balance=" + actual_balance + ", available_balance=" + available_balance
				+ ", account_bouns=" + account_bouns + ", creat_date=" + creat_date + ", update_date=" + update_date
				+ "]";
	}
	
	
	
	
	

	
}
