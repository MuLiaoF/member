package cn.wandingkeji.bonus.service;

import cn.wandingkeji.comm.enums.PayStatusEnum;
import cn.wandingkeji.comm.enums.ScenceEnum;
import cn.wandingkeji.comm.enums.TransType;
import cn.wandingkeji.member.entity.WdMemBonTrans;
import cn.wandingkeji.member.entity.WdMemBonus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 会员积分明细业务
 * @author jing_huan
 *
 */
public interface IWdMemBonTransService {
	/**
	 * 添加会员积分明细
	 * @param wdMemBonTrans
	 * @return
	 */
	//Map<String, Object> insertTrans(String rule,BigDecimal bonus,WdMember wdmember,Map<String, Object> requestMap);
/*	Map<String, Object> insertBonusTrans(int memId, int mid, int sid, int eid, String order_id, BigDecimal bouns,
			String scence, String sourceType, Map<String, Object> paramMap) ;*/
	/**
	 * 添加会员积分明细
	 * @param wdMemBonTrans
	 * @return
	 */
	int insert(WdMemBonTrans wdMemBonTrans);


	/**
	 * 更新会员积分明细
	 * @param wdMemBonTrans
	 * @return
	 */
	Map<String, Object>  updateBonusAndTrans(int mem_id, String orderId, String scence, String status);
	int updateByPrimaryKey(WdMemBonTrans wdMemBonTrans);
	List<WdMemBonTrans> selectByOrderId(Map<String, Object> whereCondition);

	Map<String,Object> selectTransCount(Map<String, Object> whereCondition);
	List<WdMemBonTrans> getAccTransByPager(Map<String, Object> whereCondition, int offset, int pageSize);
	List<Map<String,Object>> selectBounsDetail(Map<String, Object> whereCondition, int offset, int pageSize);
	WdMemBonTrans selectById(int id);
	WdMemBonTrans selectByCondition(Map<String, Object> whereCondition);

	List<Map<String,Object>> getAllIntoTrans(Map<String, Object> whereCondition);

	Map<String,Object> getTrasnsCountToPhone(Map<String, Object> whereCondition);
	List<Map<String,Object>> getAccTransToPhone(Map<String, Object> whereCondition, int offset, int pageSize);
//	boolean updateTrans(String mem_id,BigDecimal bonus,boolean isTure,Map<String, Object> requestMap);
	//add by ws 添加积分明细
	WdMemBonTrans insertBounsTrans(WdMemBonus wdMemBonus, Integer sid, Integer eid, String order_id, BigDecimal bouns,
								   ScenceEnum scence, TransType transType, Map<String, Object> paramMap);


	WdMemBonTrans updateBonusAndTrans(String orderId, PayStatusEnum payStatus);
	WdMemBonTrans selectOneByOrderId(String orderId);
}
