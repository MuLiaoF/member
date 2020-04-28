package cn.wandingkeji.service.coupon.impl;

import cn.wandingkeji.coupon.entity.WdPlatformCoupon;
import cn.wandingkeji.coupon.mapper.WdPlatformCouponMapper;
import cn.wandingkeji.service.coupon.IWdPlatformCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 平台券基础实现
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
@Service("wdPlatformCouponService")
public class WdPlatformCouponServiceImpl implements IWdPlatformCouponService {
	@Autowired
	private WdPlatformCouponMapper wdPlatformCouponMapper;
	@Override
	public WdPlatformCoupon selectById(int id) {
		
		return wdPlatformCouponMapper.selectById(id);
	}

	@Override
	public int insert(WdPlatformCoupon wdPlatformCoupon) {
		
		return wdPlatformCouponMapper.insert(wdPlatformCoupon);
	}

	@Override
	public int updateById(WdPlatformCoupon wdPlatformCoupon) {
		
		return wdPlatformCouponMapper.updateById(wdPlatformCoupon);
	}

	@Override
	public int deleteById(int id) {
		
		return wdPlatformCouponMapper.deleteById(id);
	}

	@Override
	public WdPlatformCoupon selectByCondition(Map<String, Object> whereCondition) {
		
		return wdPlatformCouponMapper.selectByCondition(whereCondition);
	}

	@Override
	public WdPlatformCoupon selectCouponByCardId(String cardId) {
		
		return wdPlatformCouponMapper.selectWxCouponByCardId(cardId);
	}

	@Override
	public List<WdPlatformCoupon> selectGiftCouponByCardid(String cardId) {
		
		return wdPlatformCouponMapper.selectGiftCouponByCardid(cardId);
	}
	/**
	 * 根据id更新券库存数量
	 */
	@Override
	public int updateByQuantity(WdPlatformCoupon wdPlatformCoupon) {
		
		return wdPlatformCouponMapper.updateByQuantity(wdPlatformCoupon);
	}




}
