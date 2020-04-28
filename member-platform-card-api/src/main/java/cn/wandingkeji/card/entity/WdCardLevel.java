package cn.wandingkeji.card.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
 * 会员卡级别
 * add by ws0708
 */
public class WdCardLevel {

	private int id;
	private Integer mid;
	private String card_id;	//会员卡ID
	private String level;//等级标识
	private String type;//等级状态
	private String sort;//等级级别排序
	private String comments;//等级内容描述(会员权益)	
	private String level_name;//用户定义等级名称
	private Timestamp creat_stamp;	//创建者时间
	private Timestamp update_stamp;	//修改时间
	private BigDecimal min_value;	//最小值
	private BigDecimal max_value;	//最大值
	private BigDecimal cum_trans_amt;//累计交易金额
	private BigDecimal discount;//等级对应的折扣率
	private BigDecimal deposit_level;//充值金额升等级
	private String loc_bac_url;//背景图片（本地）
	private String background_pic_url;//会员背景图片（微信）
	
	
	
	public BigDecimal getDeposit_level() {
		return deposit_level;
	}
	public void setDeposit_level(BigDecimal deposit_level) {
		this.deposit_level = deposit_level;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public BigDecimal getCum_trans_amt() {
		return cum_trans_amt;
	}
	public void setCum_trans_amt(BigDecimal cum_trans_amt) {
		this.cum_trans_amt = cum_trans_amt;
	}
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Timestamp getCreat_stamp() {
		return creat_stamp;
	}
	public void setCreat_stamp(Timestamp creat_stamp) {
		this.creat_stamp = creat_stamp;
	}
	public Timestamp getUpdate_stamp() {
		return update_stamp;
	}
	public void setUpdate_stamp(Timestamp update_stamp) {
		this.update_stamp = update_stamp;
	}
	public BigDecimal getMin_value() {
		return min_value;
	}
	public void setMin_value(BigDecimal min_value) {
		this.min_value = min_value;
	}
	public BigDecimal getMax_value() {
		return max_value;
	}
	public void setMax_value(BigDecimal max_value) {
		this.max_value = max_value;
	}
	public String getLoc_bac_url() {
		return loc_bac_url;
	}
	public void setLoc_bac_url(String loc_bac_url) {
		this.loc_bac_url = loc_bac_url;
	}
	public String getBackground_pic_url() {
		return background_pic_url;
	}
	public void setBackground_pic_url(String background_pic_url) {
		this.background_pic_url = background_pic_url;
	}
	
	
	
}
