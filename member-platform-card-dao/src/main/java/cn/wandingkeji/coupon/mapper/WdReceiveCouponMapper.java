package cn.wandingkeji.coupon.mapper;

import cn.wandingkeji.coupon.entity.WdReceiveCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 领取券dao
 * @author jing_huan
 *
 */
public interface WdReceiveCouponMapper {
	/**
	 * 根据主键id查询领取券信息
	 * @param id
	 * @return
	 */
	WdReceiveCoupon selectById(int id);
	/**
	 * 根据code card_id status 查询
	 * @param couponMap
	 * @return
	 */
	WdReceiveCoupon selectByCodeCardId(@Param("couponMap") WdReceiveCoupon couponMap);
	WdReceiveCoupon selectByCodeCardId2(@Param("couponMap") Map<String, Object> couponMap);

	WdReceiveCoupon selectByCode(@Param("condition") Map<String, Object> condition);

	/**
	 * 分页查询
	 */
	int selectReceiveCouponCount(@Param("condition") Map<String, Object> condition);

	//TODO
	//List<MyCouponResp>  getReceiveCouponByPager(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("pageSize") int pageSize);

	int selectCouponCount(@Param("condition") Map<String, Object> condition);
	List<WdReceiveCoupon>  getCouponByPager(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("pageSize") int pageSize);

	/**
	 * 更新领取券信息
	 * @param wdReceiveCoupon
	 * @return
	 */
	int updateById(@Param("coupon") WdReceiveCoupon wdReceiveCoupon);
	/**
	 * 根据条件删除领取券信息
	 * @param id
	 * @return
	 */
	int deleteById(int id);
	int insert(@Param("coupon") WdReceiveCoupon record);

    List<WdReceiveCoupon> selectByorderId(@Param("orderId") String orderId);

	void updateOldCoupoStatus(@Param("oldUserCardCode") String oldUserCardCode, @Param("status") String status);
}