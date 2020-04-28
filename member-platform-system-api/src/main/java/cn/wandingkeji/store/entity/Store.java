package cn.wandingkeji.store.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Store implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Store() {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private int mid;
	private String storeType;
	private String storeName;
	private String poi_id;
	private String wxStoreId;
	private String mname;
	private String telephone;
	private String longitude;
	private String latitude;
	private String shopHours;
//	private Timestamp startTime;
//	private Timestamp endTime;
	private BigDecimal avgPrice;
	private String address;
	private String photo;
	private int fsortid;
	private int sortid;
	private int circleId;
	private int cityId;
	private String cityName;
	private int provinceId;
	private String provinceName;
	private String introduction;
	private String recommend;
	private String special;
	private int districtId;
	private String districtName;
	private String state;
	private Timestamp addTime;
	private String appid;
	private String aliStoreId;
	private String snumber;
	private String revsere1;
	private String revsere2;
	private String revsere3;
	private String spwd;
	private String saccount;
	private String salt;
	private String sopenId;
	
	
	public String getSopenId() {
		return sopenId;
	}
	public void setSopenId(String sopenId) {
		this.sopenId = sopenId;
	}
	public String getPoi_id() {
		return poi_id;
	}
	public void setPoi_id(String poi_id) {
		this.poi_id = poi_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getShopHours() {
		return shopHours;
	}
	public void setShopHours(String shopHours) {
		this.shopHours = shopHours;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getWxStoreId() {
		return wxStoreId;
	}
	public void setWxStoreId(String wxStoreId) {
		this.wxStoreId = wxStoreId;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
//	public Timestamp getStartTime() {
//		return startTime;
//	}
//	public void setStartTime(Timestamp startTime) {
//		this.startTime = startTime;
//	}
//	public Timestamp getEndTime() {
//		return endTime;
//	}
//	public void setEndTime(Timestamp endTime) {
//		this.endTime = endTime;
//	}
	public BigDecimal getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(BigDecimal avgPrice) {
		this.avgPrice = avgPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public int getSortid() {
		return sortid;
	}
	public void setSortid(int sortid) {
		this.sortid = sortid;
	}
	
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
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
	
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	public String getAppid() {
		return appid;
	}
	public int getFsortid() {
		return fsortid;
	}
	public void setFsortid(int fsortid) {
		this.fsortid = fsortid;
	}
	public int getCircleId() {
		return circleId;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAliStoreId() {
		return aliStoreId;
	}
	public void setAliStoreId(String aliStoreId) {
		this.aliStoreId = aliStoreId;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public String getRevsere1() {
		return revsere1;
	}
	public void setRevsere1(String revsere1) {
		this.revsere1 = revsere1;
	}
	public String getRevsere2() {
		return revsere2;
	}
	public void setRevsere2(String revsere2) {
		this.revsere2 = revsere2;
	}
	public String getRevsere3() {
		return revsere3;
	}
	public void setRevsere3(String revsere3) {
		this.revsere3 = revsere3;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getSaccount() {
		return saccount;
	}
	public void setSaccount(String saccount) {
		this.saccount = saccount;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
