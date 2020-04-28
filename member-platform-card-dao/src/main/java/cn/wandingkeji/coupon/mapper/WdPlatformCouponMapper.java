package cn.wandingkeji.coupon.mapper;

import cn.wandingkeji.coupon.entity.WdPlatformCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 平台券dao
 * @author Administrator
 *
 */
public interface WdPlatformCouponMapper {
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
	WdPlatformCoupon selectByCondition(@Param("condition") Map<String, Object> whereCondition);
	/**
	 * 添加平台券
	 * @param wdPlatformCoupon
	 * @return
	 */
	int  insert(@Param("coupon") WdPlatformCoupon wdPlatformCoupon);
	/**
	 * 更新平台券信息
	 * @param wdPlatformCoupon
	 * @return
	 */
	int updateById(@Param("coupon") WdPlatformCoupon wdPlatformCoupon);
	int updateByQuantity(@Param("coupon") WdPlatformCoupon wdPlatformCoupon);
	/**
	 * 根据条件删除平台券信息
	 * @param couponMap
	 * @return
	 */
	int deleteById(int id);
	
	WdPlatformCoupon selectWxCouponByCardId(String card_id);
	
	List<WdPlatformCoupon> selectGiftCouponByCardid(String card_id);
}
