package cn.wandingkeji.card.entity;

import java.sql.Timestamp;

public class MiniPrograms {

	private Integer id;
	private Integer mid;
	private String appid;
	private String appname;
	private String domain;
	private String webviewdomain;
	private String category;
	private String auditid;
	private String item_list;
	private Integer status;
	private String template_id;
	private String version;
	private Timestamp gmt_create;
	private Timestamp gmt_modified;
	private Timestamp commit_time;//小程序代码提交时间
	private String reserve1;//提交小程序代码标识
	private String reserve2;
	private String reserve3;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getWebviewdomain() {
		return webviewdomain;
	}
	public void setWebviewdomain(String webviewdomain) {
		this.webviewdomain = webviewdomain;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuditid() {
		return auditid;
	}
	public void setAuditid(String auditid) {
		this.auditid = auditid;
	}
	public String getItem_list() {
		return item_list;
	}
	public void setItem_list(String item_list) {
		this.item_list = item_list;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Timestamp getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(Timestamp gmt_create) {
		this.gmt_create = gmt_create;
	}
	public Timestamp getGmt_modified() {
		return gmt_modified;
	}
	public void setGmt_modified(Timestamp gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	public String getReserve2() {
		return reserve2;
	}
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	public String getReserve3() {
		return reserve3;
	}
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	public Timestamp getCommit_time() {
		return commit_time;
	}
	public void setCommit_time(Timestamp commit_time) {
		this.commit_time = commit_time;
	}
	
}
