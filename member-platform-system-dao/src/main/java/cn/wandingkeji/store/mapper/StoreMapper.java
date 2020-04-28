package cn.wandingkeji.store.mapper;

import cn.wandingkeji.store.entity.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * dao
 * @author jing_huan
 *
 */
public interface StoreMapper {
	/**
	 * 根据主键id查询门店信息
	 * @param id
	 * @return
	 */
	Store selectById(int id);
	/**
	 * 更新门店信息
	 * @param wdPlatformCoupon
	 * @return
	 */
	int updateById(@Param("store") Store store);
	/**
	 * 根据条件删除门店信息
	 * @param couponMap
	 * @return
	 */
	int deleteById(int id);

	int insert(@Param("store") Store record);
	
	List<Map<String,Object>> getWxStoreToPhone(@Param("mid") int mid);

}