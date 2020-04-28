package cn.wandingkeji.merchant.service.impl;

import cn.wandingkeji.merchant.MerchantsMapper;
import cn.wandingkeji.merchant.entity.Merchants;
import cn.wandingkeji.merchant.service.IMerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 领取卡券的业务处理
 * @author Administrator
 * @date 2019年5月17日
 *
 */
@Service("merchantService")
public class MerchantServiceImpl implements IMerchantService {
	
	private static final Logger log = LoggerFactory.getLogger(MerchantServiceImpl.class);
	
	@Autowired
	private MerchantsMapper merchantMapper;
	@Override
	public Merchants selectById(int mid) {
		
		return merchantMapper.selectById(mid);
	}
	@Override
	public int updateById(Merchants merchants) {
		
		return merchantMapper.updateById(merchants);
	}
	@Override
	public int insert(Merchants record) {
		
		return merchantMapper.insert(record);
	}

	@Override
	public Merchants selectByThridMid(Integer mid) {
		return merchantMapper.selectByThridMid(mid);
	}

}
