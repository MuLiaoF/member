package cn.wandingkeji.merchant;

import cn.wandingkeji.merchant.entity.Merchants;
import org.apache.ibatis.annotations.Param;

/**
 * dao
 * @author jing_huan
 *
 */
public interface MerchantsMapper {
	/**
	 * 根据主键id查询商户信息
	 * @param mid
	 * @return
	 */
	Merchants selectById(@Param("mid") int mid);
	/**
	 * 更新商户信息
	 * @param merchants
	 * @return
	 */
	int updateById(@Param("merchants") Merchants merchants);
	/**
	 * 根据条件删除商户信息
	 * @param mid
	 * @return
	 */
	int deleteById(@Param("mid") int mid);

	int insert(@Param("merchants") Merchants record);

	Merchants selectByThridMid(Integer mid);
}