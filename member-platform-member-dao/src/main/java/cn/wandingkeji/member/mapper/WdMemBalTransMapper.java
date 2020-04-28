package cn.wandingkeji.member.mapper;

import cn.wandingkeji.member.entity.WdMemBalTrans;
import cn.wandingkeji.member.entity.WdMemConsumeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *  会员余额明细DAO
 * @author jing_huan
 * @date 2019-05-25
 */
public interface WdMemBalTransMapper {
	
	WdMemBalTrans selectById(int id);
	WdMemBalTrans selectByCondtion(@Param("condition") Map<String, Object> whereCondition);

	/**
	 * 添加会员账户明细
	 * @param wdMemBalTrans
	 * @return
	 */
	int insert(@Param("wdMemBalTrans") WdMemBalTrans wdMemBalTrans);
	/**
	 * 更新会员账户明细
	 * @param wdMemBalTrans
	 * @return
	 */
	int updateByPrimaryKey(@Param("wdMemBalTrans") WdMemBalTrans wdMemBalTrans);
	List<WdMemBalTrans> selectByOrderId(@Param("condition") Map<String, Object> whereCondition);

	Map<String,Object> selectTransCount(@Param("condition") Map<String, Object> whereCondition);
	List<Map<String,Object>> getAccTransByPager(@Param("condition") Map<String, Object> whereCondition, @Param("offset") int offset, @Param("pageSize") int pageSize);
	List<Map<String,Object>> selectBounsDetail(@Param("condition") Map<String, Object> whereCondition, @Param("offset") int offset, @Param("pageSize") int pageSize);
	List<Map<String,Object>> getAllIntoTrans(@Param("condition") Map<String, Object> whereCondition);

	Map<String,Object> getTrasnsCountToPhone(@Param("condition") Map<String, Object> whereCondition);
	List<Map<String,Object>> getAccTransToPhone(@Param("condition") Map<String, Object> whereCondition, @Param("offset") int offset, @Param("pageSize") int pageSize);

	WdMemBalTrans selectOneByOrderId(@Param("orderId") String orderId);

	/**
	 *
	 * @param orderId orderID
	 * @return sid
	 */
	int selectConsumeByOrderId(@Param("orderId") String orderId);

	int insertMemConsumeInfo(@Param("memInfo") WdMemConsumeInfo memInfo);

	int updateMemConsumeInfo(@Param("memInfo") WdMemConsumeInfo memInfo);

	WdMemConsumeInfo queryMemConsumeByOrderId(@Param("orderId") String orderId);


	
}