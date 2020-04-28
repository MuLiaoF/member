package cn.wandingkeji.service.card.impl;

import cn.wandingkeji.card.entity.WdReceiveCardRule;
import cn.wandingkeji.card.mapper.WdReceiveCardRuleMapper;
import cn.wandingkeji.service.card.IWdReceiveCardRuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 会员卡基础实现
 * 
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
@Service("wdReceiveCardRuleService")
public class WdRecieveCardRuleServiceImpl implements IWdReceiveCardRuleService {
	private static final Logger log = LoggerFactory.getLogger(WdRecieveCardRuleServiceImpl.class);
	@Autowired
	private WdReceiveCardRuleMapper wdReceiveCardRuleMapper;
	@Override
	public WdReceiveCardRule selectById(int id) {
		// TODO Auto-generated method stub
		return wdReceiveCardRuleMapper.selectById(id);
	}
	@Override
	public WdReceiveCardRule selectByWxCardId(String wxCardId) {
		// TODO Auto-generated method stub
		return wdReceiveCardRuleMapper.selectByWxCardId(wxCardId);
	}
	@Override
	public int updateById(WdReceiveCardRule wdReceiveCardRule) {
		// TODO Auto-generated method stub
		return wdReceiveCardRuleMapper.updateById(wdReceiveCardRule);
	}
	@Override
	public int insert(WdReceiveCardRule wdReceiveCardRule) {
		// TODO Auto-generated method stub
		return wdReceiveCardRuleMapper.insert(wdReceiveCardRule);
	}



}
