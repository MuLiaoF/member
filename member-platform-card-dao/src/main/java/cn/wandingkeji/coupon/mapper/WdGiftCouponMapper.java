package cn.wandingkeji.coupon.mapper;

import cn.wandingkeji.coupon.entity.WdGiftCoupon;
import org.apache.ibatis.annotations.Param;

/**
 * 礼包券dao
 * @author Administrator
 *
 */
public interface WdGiftCouponMapper {
	
	/**
	 * 根据主键id查询礼包券信息
	 * @param id
	 * @return
	 */
	WdGiftCoupon selectById(int id);
	/**
	 * 添加礼包券
	 * @param wdGiftCoupon
	 * @return
	 */
	int  insert(@Param("coupon") WdGiftCoupon wdGiftCoupon);
	/**
	 * 更新礼包券信息
	 * @param wdGiftCoupon
	 * @return
	 */
	int updateById(@Param("coupon") WdGiftCoupon wdGiftCoupon);
	/**
	 * 根据条件删除礼包券信息
	 * @param id
	 * @return
	 */
	int deleteById(int id);
}
