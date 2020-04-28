package cn.wandingkeji.service.coupon.impl;

import cn.wandingkeji.coupon.entity.WdWxCoupon;
import cn.wandingkeji.coupon.mapper.WdWxCouponMapper;
import cn.wandingkeji.service.coupon.IWdWxCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 平台券基础业务
 * @author Administrator
 * @date 2019年5月22日
 *
 */
@Service("wdWxCouponService")
public class WdWxCouponServiceImpl implements IWdWxCouponService {
	
	
	@Autowired
	private WdWxCouponMapper wdWxCouponMapper;
	@Override
	public WdWxCoupon selectWxById(int id) {
		// TODO Auto-generated method stub
		return wdWxCouponMapper.selectWxById(id);
	}
	@Override
	public WdWxCoupon  selectByCardId(String cardId){
		// TODO Auto-generated method stub
		return wdWxCouponMapper.selectByCardId(cardId);
	}

	@Override
	public int insertWx(WdWxCoupon wdWxCoupon) {
		// TODO Auto-generated method stub
		return wdWxCouponMapper.insertWx(wdWxCoupon);
	}

	@Override
	public int updateWxById(WdWxCoupon wdWxCoupon) {
		// TODO Auto-generated method stub
		return wdWxCouponMapper.updateWxById(wdWxCoupon);
	}

	@Override
	public int deleteWxById(int id) {
		// TODO Auto-generated method stub
		return wdWxCouponMapper.deleteWxById(id);
	}
	@Override
	public WdWxCoupon selectByCondition(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return wdWxCouponMapper.selectByCondition(condition);
	}

}
