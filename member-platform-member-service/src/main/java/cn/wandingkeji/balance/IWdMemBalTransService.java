package cn.wandingkeji.balance;

import cn.wandingkeji.comm.enums.PayStatusEnum;
import cn.wandingkeji.comm.enums.ScenceEnum;
import cn.wandingkeji.comm.enums.TransType;
import cn.wandingkeji.member.entity.WdMemBalTrans;
import cn.wandingkeji.member.entity.WdMemBalance;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 会员余额明细基础业务
 * @author jing_huan
 * @date 2019年5月22日
 *
 */
public interface IWdMemBalTransService {
	/**
	 * 根据条件查询余额明细
	 * @param whereCondition
	 * @return
	 */
	WdMemBalTrans selectByCondtion(Map<String, Object> whereCondition);

	/**
	 * 组装参数添加会员余额明细
	 * @param wdMemBalTrans
	 * @return
	 */
	//Map<String,Object> insertBalanceTrans(int memId, int mid, int sid, int eid, String order_id, BigDecimal amount,
	//		String scence, String sourceType, Map<String, Object> paramMap);
	/**
	 * 添加会员余额明细
	 * @param wdMemBalTrans
	 * @return
	 */
	int insert(WdMemBalTrans wdMemBalTrans);
	/**
	 * 更新会员余额明细
	 * @param wdMemBalTrans
	 * @return
	 */
	int updateByPrimaryKey(WdMemBalTrans wdMemBalTrans);
	List<WdMemBalTrans> selectByOrderId(Map<String, Object> whereCondition);

	Map<String,Object> selectTransCount(Map<String, Object> whereCondition);
	List<Map<String,Object>> getAccTransByPager(Map<String, Object> whereCondition, int offset, int pageSize);
	List<Map<String,Object>> selectBounsDetail(Map<String, Object> whereCondition, int offset, int pageSize);
	WdMemBalTrans selectById(int id);

	List<Map<String,Object>> getAllIntoTrans(Map<String, Object> whereCondition);

	Map<String,Object> getTrasnsCountToPhone(Map<String, Object> whereCondition);
	List<Map<String,Object>> getAccTransToPhone(Map<String, Object> whereCondition, int offset, int pageSize);

	//WdMemBalTrans insertBalanceTrans(WdMemBalance wdMemBalance, Integer sid, Integer eid, String order_id, BigDecimal amount,
	//								 ScenceEnum scence, TransType transType, Map<String, Object> paramMap, String employee_no);

	//WdMemBalTrans updateTransAndBalance(String orderId, PayStatusEnum payStatus);
	
	WdMemBalTrans selectOneByOrderId(String orderId);
	
}
