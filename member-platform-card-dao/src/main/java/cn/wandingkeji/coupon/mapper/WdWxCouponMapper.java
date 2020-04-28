package cn.wandingkeji.coupon.mapper;


import cn.wandingkeji.coupon.entity.WdWxCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.Map;


/**
 * 微信官方券dao
 * @author jing_huan
 *
 */
public interface WdWxCouponMapper {
	
	/**
	 * 根据主键id查询官方券信息
	 * @param id
	 * @return
	 */
	WdWxCoupon selectWxById(int id);
	WdWxCoupon selectByCardId(String cardId);
	WdWxCoupon selectByCondition(@Param("condition") Map<String, Object> condition);
	/**
	 * 添加官方券
	 * @param wdWxCoupon
	 * @return
	 */
	int  insertWx(@Param("coupon") WdWxCoupon wdWxCoupon);
	/**
	 * 更新官方券
	 * @param wdWxCoupon
	 * @return
	 */
	int updateWxById(@Param("coupon") WdWxCoupon wdWxCoupon);
	/**
	 * 根据条件删除官方券
	 * @param id
	 * @return
	 */
	int deleteWxById(int id);
}
