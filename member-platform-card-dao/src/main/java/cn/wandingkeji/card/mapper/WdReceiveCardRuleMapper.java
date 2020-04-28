package cn.wandingkeji.card.mapper;

import cn.wandingkeji.card.entity.WdReceiveCardRule;
import org.apache.ibatis.annotations.Param;

/**
 * 领取会员卡DAO
 * @author jing_huan
 *
 */
public interface WdReceiveCardRuleMapper {
	/**
	 * 根据主键id查询领取会员卡信息
	 * @param id
	 * @return
	 */
	WdReceiveCardRule selectById(int id);
	/**
	 * 更新领取会员卡信息
	 * @param wdReceiveCardRule
	 * @return
	 */
	int updateById(@Param("wdReceiveCardRule") WdReceiveCardRule wdReceiveCardRule);

	int insert(@Param("wdReceiveCardRule") WdReceiveCardRule record);

	WdReceiveCardRule selectByWxCardId(String wxCardId);
	// TODO
	//WdBuyCardOrder selectByCardIdAndopenId(@Param("cardId") String cardId, @Param("openId") String openid);
}