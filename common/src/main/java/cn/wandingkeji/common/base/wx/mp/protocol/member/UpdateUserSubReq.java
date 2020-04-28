package cn.wandingkeji.common.base.wx.mp.protocol.member;


/*
 *  更新会员信息(含余额)
 *  add by ws
 *  0520
 */
public class UpdateUserSubReq extends UpdateUserReq{


	private Integer balance;
	private Integer add_balance;
	private String record_balance;
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Integer getAdd_balance() {
		return add_balance;
	}
	public void setAdd_balance(Integer add_balance) {
		this.add_balance = add_balance;
	}
	public String getRecord_balance() {
		return record_balance;
	}
	public void setRecord_balance(String record_balance) {
		this.record_balance = record_balance;
	}
	
	
	
	
	
	
}
