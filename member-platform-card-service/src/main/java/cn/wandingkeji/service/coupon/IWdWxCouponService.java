package cn.wandingkeji.service.coupon;

import cn.wandingkeji.coupon.entity.WdWxCoupon;

import java.util.Map;

/**
 * 官方券基础业务
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
public interface IWdWxCouponService {
	/**
	 * 根据主键id查询官方券信息
	 * @param id
	 * @return
	 */
	
	WdWxCoupon selectWxById(int id);
	WdWxCoupon selectByCardId(String cardId);
	WdWxCoupon selectByCondition(Map<String, Object> condition);
	/**
	 * 添加官方券
	 * @param wdWxCoupon
	 * @return
	 */
	int  insertWx(WdWxCoupon wdWxCoupon);
	/**
	 * 更新官方券
	 * @param wdWxCoupon
	 * @return
	 */
	int updateWxById(WdWxCoupon wdWxCoupon);
	/**
	 * 根据条件删除官方券
	 * @param id
	 * @return
	 */
	int deleteWxById(int id);
	
	
}
