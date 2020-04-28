package cn.wandingkeji.member.mapper;

import cn.wandingkeji.member.entity.WdMemBonTrans;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *  会员积分明细DAO
 * @author jing_huan
 *
 */
public interface WdMemBonTransMapper {
	
	/**
	 * 添加会员账户明细
	 * @param wdMemBonTrans
	 * @return
	 */
	int insert(@Param("wdMemBonTrans") WdMemBonTrans wdMemBonTrans);
	/**
	 * 更新会员账户明细
	 * @param wdMemBonTrans
	 * @return
	 */
	int updateByPrimaryKey(@Param("wdMemBonTrans") WdMemBonTrans wdMemBonTrans);
	List<WdMemBonTrans> selectByOrderId(@Param("condition") Map<String, Object> whereCondition);

	Map<String,Object> selectTransCount(@Param("condition") Map<String, Object> whereCondition);
	List<WdMemBonTrans> getAccTransByPager(@Param("condition") Map<String, Object> whereCondition, @Param("offset") int offset, @Param("pageSize") int pageSize);
	List<Map<String,Object>> selectBounsDetail(@Param("condition") Map<String, Object> whereCondition, @Param("offset") int offset, @Param("pageSize") int pageSize);
	WdMemBonTrans selectById(int id);
	WdMemBonTrans selectByCondition(@Param("condition") Map<String, Object> whereCondition);

	List<Map<String,Object>> getAllIntoTrans(@Param("condition") Map<String, Object> whereCondition);

	Map<String,Object> getTrasnsCountToPhone(@Param("condition") Map<String, Object> whereCondition);
	List<Map<String,Object>> getAccTransToPhone(@Param("condition") Map<String, Object> whereCondition, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	
	WdMemBonTrans selectOneByOrderId(@Param("orderId") String orderId);
}