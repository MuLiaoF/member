package cn.wandingkeji.comm.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *  TODO　
 * 场景 来源枚举值
 * @author jing_huan
 *
 */
public enum ScenceEnum {
	// 场景 
	/**
	 * 充值 
	 */
	SCZ("CZ","充值"),
	/**
	 * 消费 
	 */
	SXF("XF","消费"),
	REFUND("REFUND","退款"),
	/**
	 * 积分兑换
	 */
	SDH("DH","积分兑换"),
	
	/**
	 * 来源
	 */
	/**
	 * 团购orderID 80
	 */
	TTG("TG","团购"),
	TMS("MS","秒杀"),
	CZLK("CZLK","充值领卡"),
	/**
	 * 参团orderID 82
	 */
	TCT("CT","参团"),
	/**
	 * 拼团orderID 81
	 */
	POSXF("POSXF","POS收款"),
	POSBUYCARD("POSBUYCARD","POS付费购卡"),
	POSDEPOSIT("POSDEPOSIT","POS会员充值"),
	CZZS("CZZS","充值赠送"),
	PCDEPOSITBONUS("PCDEPOSITBONUS","PC端充积分"),
	PCDEPOSITBALANCE("PCDEPOSITBALANCE","PC端充余额"),
	OLDBIND("OLDBIND","老会员绑定"),
	LBZS("LBZS","会员裂变"),
	FXCZJL("FXCZJL","下级会员充值"),
	FXXFJL("FXXFJL","下级会员消费"),
	TPT("PT","拼团");
	private String scence;
	private String msg;
	private ScenceEnum(String scence, String msg) {
		this.scence = scence;
		this.msg = msg;
	}
	public String getScence() {
		return scence;
	}
	public void setScence(String scence) {
		this.scence = scence;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	private static List<ScenceEnum> scenceList = new ArrayList<ScenceEnum>();
	static {
		ScenceEnum[] values = ScenceEnum.values();
		for(ScenceEnum scence:values){
			scenceList.add(scence);
		}
	}
	public static List<ScenceEnum> getAllRateCode(){
		
		
		return scenceList;
	}
	//add by wangsen
	public static  ScenceEnum getValueByScence(String scence){
		ScenceEnum resutl = null; 
		
		for(ScenceEnum key:scenceList){
			if(key.getScence().equals(scence)){
				resutl = key;
				break;
				
			}
		}
		return resutl;
	}
	
	
}
