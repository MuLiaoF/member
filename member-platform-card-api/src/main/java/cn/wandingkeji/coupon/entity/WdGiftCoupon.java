package cn.wandingkeji.coupon.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author Administrator
 *
 * 礼包券实体
 */
public class WdGiftCoupon  implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private int id;
	/**
	 * 卡卷编号(与平台礼包关联)
	 */
	private String card_id;
	/**
	 * 关联劵编号(礼包劵中包含的劵编号)
	 */
	private String relation_coupon_id;
	/**
	 * 状态(可根据状态判断是否删除礼包劵中包含的其他劵)
	 */
	private String status;
	/**
	 * 卡券名称
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

	public String getWxcard_id() {
		return wxcard_id;
	}

	public void setWxcard_id(String wxcard_id) {
		this.wxcard_id = wxcard_id;
	}

	/**
	 * wx _card_id
	 */
	private String wxcard_id;
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCard_id() {
		return card_id;
	}



	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}



	public String getRelation_coupon_id() {
		return relation_coupon_id;
	}



	public void setRelation_coupon_id(String relation_coupon_id) {
		this.relation_coupon_id = relation_coupon_id;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getCoupon_name() {
		return coupon_name;
	}



	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}



	public Timestamp getCreat_time() {
		return creat_time;
	}



	public void setCreat_time(Timestamp creat_time) {
		this.creat_time = creat_time;
	}



	public Timestamp getUpdate_time() {
		return update_time;
	}



	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}



	public String getReserve() {
		return reserve;
	}



	public void setReserve(String reserve) {
		this.reserve = reserve;
	}



	@Override
	public String toString() {
		return "WdGiftCoupon [id=" + id + ", card_id=" + card_id + ", relation_coupon_id=" + relation_coupon_id
				+ ", status=" + status + ", coupon_name=" + coupon_name + ", creat_time=" + creat_time
				+ ", update_time=" + update_time + ", reserve=" + reserve + "]";
	}
	
	
	
}
