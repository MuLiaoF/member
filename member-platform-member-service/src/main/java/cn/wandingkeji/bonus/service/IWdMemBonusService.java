package cn.wandingkeji.bonus.service;

import cn.wandingkeji.card.entity.WdMemCard;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUserInfoRes;
import cn.wandingkeji.member.entity.WdMemBonus;
import cn.wandingkeji.member.entity.WdMember;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 会员积分业务接口
 * @author jing_huan<br>
 * @Date 2019-05-25
 *
 */
public interface IWdMemBonusService {
	/**
	 * 更新积分以及添加积分变动明细记录
	 * @param requestMap
	 * @return
	 */
	boolean updateBonusAndTrans(int mem_id, BigDecimal bonus, boolean isTure, Map<String, Object> requestMap);
	/**
	 * 根据主键id查询会员积分信息
	 * @param id
	 * @return
	 */
	WdMemBonus selectById(int id);
	WdMemBonus selectByCondition(Map<String, Object> condition);
	/**
	 * 添加会员积分
	 * @param wdMemBrancht
	 * @return
	 */
	int insert(WdMemBonus wdMemBrancht);
	/**
	 * 更新会员积分信息
	 * @param wdMemBranch
	 * @return
	 */
	int updateById(WdMemBonus wdMemBranch);
	/**
	 * 删除会员积分
	 * @param id
	 * @return
	 */
	int deleteById(int id);



	int insertWdMemBonus(WdMember updateWdMember, GetUserInfoRes getUserInfoRes, WdMemCard memCard,
						 String cardId, String code);
	
	
	WdMemBonus selectByMemId(int memId);
	
	
	
}
