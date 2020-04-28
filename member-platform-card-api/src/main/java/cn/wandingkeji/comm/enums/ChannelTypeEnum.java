package cn.wandingkeji.comm.enums;

public enum ChannelTypeEnum {
	
	WX("WX","微信官方券"),
	WD_FREQ("WD_FREQ","万鼎计次卡"),
	WD_GIFT("WD_GIFT","万鼎礼包券");
	
	private String channelType;
	private String desc;
	
	private ChannelTypeEnum(String channelType, String desc){
		this.channelType = channelType;
		this.desc = desc;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
