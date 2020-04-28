package cn.wandingkeji.balance;

import cn.wandingkeji.card.entity.WdMemCard;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUserInfoRes;
import cn.wandingkeji.member.entity.WdMemBalance;
import cn.wandingkeji.member.entity.WdMember;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 会员账户余额基础业务
 * @author jing_huan
 * @date 2019年5月22日
 *
 */
public interface IWdMemBalanceService {
	// TODO
	//Map<String,Object> updateMemBalanceAndBonu(WdMember member, MemOrderRecord memOrderRecord);
	//Map<String,Object> updateMemBalanceAndBonus(String member_id,BigDecimal bonus,boolean isTure,BigDecimal balance,Map<String, Object> requestMap);
	/**
	 * 支付完成功后收到通知更新余额积分变动明细,并且更新余额 积分
	 * @param requestMap
	 * @return
	 */
	//Map<String,Object> updateMemCardRechargeRecord(Map<String, Object> requestMap);
	/**
	 * 充值前先添加余额积分变动明细
	 * @param requestMap
	 * @return
	 */
	Map<String,Object> insertMemCardRechargeRecord(String rule, BigDecimal balance, WdMember wdmember, Map<String, Object> requestMap);

	/**
	 * 会员余额变动以及添加余额明细方法
	 */
	Map<String,Object> updateBalanceAndTrans(Map<String, Object> requestMap);

	/**
	 * 根据主键Id查询会员余额信息
	 * @param id
	 * @return
	 */
	WdMemBalance selectByBalanceId(int id);

	WdMemBalance selectByCondition(Map<String, Object> condition);
	WdMemBalance selectByMemId(@Param("member_id") String member_id);
	/**
	 * 添加会员账户
	 * @param wdMemBalance
	 * @return
	 */
	int insert(WdMemBalance wdMemBalance);
	/**
	 * 更新会员账户信息
	 * @param wdMemBalance
	 * @return
	 */
	int updateByBalanceId(WdMemBalance wdMemBalance);
	/**
	 * 删除会员账户
	 * @param id
	 * @return
	 */
	int deleteByBalanceId(int id);

	// TODO　
	int insertWdMemBalance(WdMember updateWdMember, GetUserInfoRes getUserInfoRes, WdMemCard memCard, String cardId, String code);

	boolean updateBalanceAndTrans2(int mem_id, BigDecimal balance, String orderId, String scence);

	Map<String, Object>  updateBalanceAndTrans3(int mem_id, String orderId, String scence, String status);


	Map<String, Object> payment(String mdCode, String memId, BigDecimal price, Map<String, Object> memDonate);
}
