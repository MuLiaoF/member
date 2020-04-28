package cn.wandingkeji.service.coupon.impl;

import cn.wandingkeji.coupon.entity.WdReceiveCoupon;
import cn.wandingkeji.coupon.mapper.WdReceiveCouponMapper;
import cn.wandingkeji.service.coupon.IReceiveCouponService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 领取券的业务处理
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
@Slf4j
@Service("receiveCouponService")
public class ReceiveCouponServiceImpl implements IReceiveCouponService {

	@Autowired
	private WdReceiveCouponMapper wdReceiveCouponMapper;

	@Override
	public WdReceiveCoupon selectById(int id) {
		
		return wdReceiveCouponMapper.selectById(id);
	}

	@Override
	public int updateById(WdReceiveCoupon wdReceiveCoupon) {
		
		return wdReceiveCouponMapper.updateById(wdReceiveCoupon);
	}

	@Override
	public int deleteById(int id) {
		
		return wdReceiveCouponMapper.deleteById(id);
	}

	@Override
	public int insert(WdReceiveCoupon record) {
		
		return wdReceiveCouponMapper.insert(record);
	}

	@Override
	public int insertSelective(WdReceiveCoupon record) {
		
		return wdReceiveCouponMapper.insert(record);
	}

	@Override
	public WdReceiveCoupon selectByCodeCardId(Map<String, Object> couponMap) {
		
		return wdReceiveCouponMapper.selectByCodeCardId2(couponMap);
	}

	@Override
	public int selectReceiveCouponCount(Map<String, Object> condition) {
		
		return wdReceiveCouponMapper.selectReceiveCouponCount(condition);
	}

	/*@Override
	public List<MyCouponResp> getReceiveCouponByPager(Map<String, Object> condition, int offset, int pageSize) {
		
		return wdReceiveCouponMapper.getReceiveCouponByPager(condition, offset, pageSize);
	}*/
		
	/*
	 * (non-Javadoc)更新劵的状态 事件推送
	 * @see com.weupay.weixin.card.service.WdCouponServiceI#updateStatusByCode(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateStatusByCode(Map<String, Object> requestMap){
	    log.info("核销事件推送 ,更新领劵状态参数"+requestMap.toString());
		String code = (String) requestMap.get("UserCardCode");
    	String cardId = (String) requestMap.get("CardId");
    	String storeName = (String)requestMap.get("LocationName");//门店名称
    	log.info("核销劵的门店名称显示"+storeName);
    	String StaffOpenId = (String)requestMap.get("StaffOpenId");//核销员openId
    	String ConsumeSource = (String)requestMap.get("ConsumeSource");
		Map<String,Object> whereCondition = new HashMap<>();
		whereCondition.put("code", code);
		whereCondition.put("card_id", cardId);
		WdReceiveCoupon wdReceiveCoupon=wdReceiveCouponMapper.selectByCode(whereCondition);
		
		WdReceiveCoupon updateWdCoupon = new WdReceiveCoupon();
		updateWdCoupon.setStatus("2");
		updateWdCoupon.setId(wdReceiveCoupon.getId());
		if(StringUtils.isNotEmpty(storeName)){
			updateWdCoupon.setStore_name(storeName);
		}
		if(StringUtils.isNotEmpty(StaffOpenId)){
			updateWdCoupon.setCheck_openid(StaffOpenId);
		}
		if(StringUtils.isNotEmpty(ConsumeSource)){
			updateWdCoupon.setConsume_source(ConsumeSource);
		}
		wdReceiveCouponMapper.updateById(updateWdCoupon);
	}

	@Override
	public List<WdReceiveCoupon> selectByorderId(String orderId) {
		return wdReceiveCouponMapper.selectByorderId(orderId);
	}

	@Override
	public void updateOldCoupoStatus(String oldUserCardCode, String status) {
		wdReceiveCouponMapper.updateOldCoupoStatus(oldUserCardCode, status);
	}

}
