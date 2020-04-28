package cn.wandingkeji.comm.enums;

import java.util.HashMap;
import java.util.Map;

public enum LevelType {

	LV1("lv1","最低等级"),
	LV2("lv2","二级"),
	LV3("lv3","三级"),
	LV4("lv4","四级"),
	LV5("lv5","五级"),
	LV6("lv6","六级"),
	LV7("lv7","七级"),
	LV8("lv8","八级"),
	LV9("lv9","九级"),
	LV10("lv10","最高等级");
	
	
	
	private String level = "";
	private String desc = "";
	private LevelType(String level, String desc){
		this.level = level;
		this.desc = desc;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static Map<String,Object> getLevelMap(){
		Map<String,Object> levelMap = new HashMap<String, Object>();
		LevelType[] values = LevelType.values();
		for(LevelType le:values) {
			levelMap.put(le.getLevel(), le.getDesc());
		}
		return levelMap;
	}
	
}
