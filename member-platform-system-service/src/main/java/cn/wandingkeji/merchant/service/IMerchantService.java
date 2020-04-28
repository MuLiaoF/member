package cn.wandingkeji.merchant.service;

import cn.wandingkeji.merchant.entity.Merchants;

/**
 * @author 王森
 * @date 2019年5月29日
 *
 */
public interface IMerchantService {
	Merchants selectById(int mid);
	/**
	 * 更新商户信息
	 * @param merchants
	 * @return
	 */
	int updateById(Merchants merchants);
	
	int insert(Merchants record);

	Merchants selectByThridMid(Integer mid);
}
