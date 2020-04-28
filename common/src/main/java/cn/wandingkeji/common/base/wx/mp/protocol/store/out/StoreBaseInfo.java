package cn.wandingkeji.common.base.wx.mp.protocol.store.out;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/*
 * 查询门店信息的baseInfo
 * add by ws
 */

public class StoreBaseInfo {

	private String sid;
	private String business_name;
	private String branch_name;
	private String address;
	private String telephone;
	private List<String> categories;
	private String city;
	private String province;
	private int offset_type;
	private String longitude;
	private String latitude;
	List<Map<String,Object>> photo_list;
	private String introduction;
	private String recommend;
	private String special;
	
	private String open_time;
	private BigDecimal avg_price;
	private String poi_id;
	private int available_state;
	private String district;
	private int update_status;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public int getOffset_type() {
		return offset_type;
	}
	public void setOffset_type(int offset_type) {
		this.offset_type = offset_type;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public List<Map<String, Object>> getPhoto_list() {
		return photo_list;
	}
	public void setPhoto_list(List<Map<String, Object>> photo_list) {
		this.photo_list = photo_list;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getOpen_time() {
		return open_time;
	}
	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}
	public BigDecimal getAvg_price() {
		return avg_price;
	}
	public void setAvg_price(BigDecimal avg_price) {
		this.avg_price = avg_price;
	}
	public String getPoi_id() {
		return poi_id;
	}
	public void setPoi_id(String poi_id) {
		this.poi_id = poi_id;
	}
	public int getAvailable_state() {
		return available_state;
	}
	public void setAvailable_state(int available_state) {
		this.available_state = available_state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getUpdate_status() {
		return update_status;
	}
	public void setUpdate_status(int update_status) {
		this.update_status = update_status;
	}
	
	
	
}
