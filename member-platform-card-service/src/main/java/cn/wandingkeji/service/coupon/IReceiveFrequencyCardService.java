package cn.wandingkeji.service.coupon;

import java.util.Map;

/**
 * 计次卡业务(领取和核销)
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
public interface IReceiveFrequencyCardService {
	/**
	 * 1领取计次卡业务
	 * @return
	 */
	Map<String,Object> ReceiveFrequencyCard(String cardId, String code, Map<String, Object> param);
	/**
	 * 2核销计次卡业务
	 * @return
	 */
	Map<String,Object> WriteOffFrequencyCard(String cardId, String code, Map<String, Object> param);
	
}
