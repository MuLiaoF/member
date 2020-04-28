package cn.wandingkeji.service.coupon;

import cn.wandingkeji.common.utils.WriteOffBean;

import java.util.Map;

/**
 * 核销卡券业务处理
 * @author jing_huan
 *
 */
public interface IWriteOffCouponService {
	/**
	 * 核销券
	 * @return
	 */
	//TODO
	//Map<String,Object> checkCoupon(String code, String cardId, int mid, String tokenUrl);
	
	/**
	 * 核销微信官方券
	 * @return
	 */

	WriteOffBean WriteOffCoupon(String code, String cardId, String token);
	
}
