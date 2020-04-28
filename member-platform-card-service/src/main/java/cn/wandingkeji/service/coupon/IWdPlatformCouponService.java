package cn.wandingkeji.service.coupon;

import cn.wandingkeji.coupon.entity.WdPlatformCoupon;

import java.util.List;
import java.util.Map;

/**
 * 平台券基础service
 * @author jing_huan
 *
 */
public interface IWdPlatformCouponService {
	/**
	 * 根据主键id查询平台券信息
	 * @param id
	 * @return
	 */
	WdPlatformCoupon selectById(int id);
	
	/**
	 * 根据条件查询平台券信息
	 * @param whereCondition
	 * @return
	 */
	WdPlatformCoupon selectByCondition(Map<String, Object> whereCondition);
	/**
	 * 添加平台券
	 * @param wdPlatformCoupon
	 * @return
	 */
	int  insert(WdPlatformCoupon wdPlatformCoupon);
	/**
	 * 更新平台券信息
	 * @param wdPlatformCoupon
	 * @return
	 */
	int updateById(WdPlatformCoupon wdPlatformCoupon);
	int updateByQuantity(WdPlatformCoupon wdPlatformCoupon);
	/**
	 * 根据条件删除平台券信息
	 * @param couponMap
	 * @return
	 */
	int deleteById(int id);
	/*
	 * 	通过平台cardid查询对象
	 */
	WdPlatformCoupon selectCouponByCardId(String cardId);
	
	List<WdPlatformCoupon> selectGiftCouponByCardid(String cardId);
}
