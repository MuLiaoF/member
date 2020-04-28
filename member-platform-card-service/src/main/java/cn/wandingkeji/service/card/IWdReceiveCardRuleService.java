package cn.wandingkeji.service.card;

import cn.wandingkeji.card.entity.WdReceiveCardRule;

/**
 * 会员卡基础service
 * @author Administrator
 * @date 2019年5月17日
 *
 */
public interface IWdReceiveCardRuleService {
	
	/**
	 * 根据主键id查询会员卡信息
	 * @param id
	 * @return
	 */
	WdReceiveCardRule selectById(int id);
	
	WdReceiveCardRule selectByWxCardId(String wxCardId);
	
	
	/**
	 * 更新会员卡信息
	 * @param wdReceiveCardRule
	 * @return
	 */
	int updateById(WdReceiveCardRule wdReceiveCardRule);
	/**
	 * 根据id条件删除会员卡信息
	 * @param wdReceiveCardRule
	 * @return
	 */
	int insert(WdReceiveCardRule wdReceiveCardRule);

}
