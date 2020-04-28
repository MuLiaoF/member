package cn.wandingkeji.service.coupon;

import cn.wandingkeji.coupon.entity.WdReceiveCoupon;

import java.util.List;
import java.util.Map;

/**
 * 领券基础业务
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
public interface IReceiveCouponService {
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
	WdReceiveCoupon selectByCodeCardId(Map<String, Object> couponMap);
	/**
	 * 分页查询
	 */
	int selectReceiveCouponCount(Map<String, Object> condition);

	//TODO　
	//List<MyCouponResp>  getReceiveCouponByPager(Map<String, Object> condition, int offset, int pageSize);
	//WdReceiveCoupon selectByCode(Map<String,Object> condition);
	/**
	 * 更新领取券信息
	 * @param wdPlatformCoupon
	 * @return
	 */
	int updateById(WdReceiveCoupon wdReceiveCoupon);
	/**
	 * 根据条件删除领取券信息
	 * @param couponMap
	 * @return
	 */
	int deleteById(int id);
	int insert(WdReceiveCoupon record);
    int insertSelective(WdReceiveCoupon record);
    /**
     * 接受微信券核销后的事件通知,更新本地数据
     * @param requestMap
     */
    void updateStatusByCode(Map<String, Object> requestMap);

    List<WdReceiveCoupon> selectByorderId(String orderId);

	void updateOldCoupoStatus(String oldUserCardCode, String s);
}
