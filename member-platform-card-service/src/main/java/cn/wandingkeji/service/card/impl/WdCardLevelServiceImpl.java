package cn.wandingkeji.service.card.impl;

import cn.wandingkeji.card.entity.WdCardLevel;
import cn.wandingkeji.card.mapper.WdCardLevelMapper;
import cn.wandingkeji.comm.enums.LevelType;
import cn.wandingkeji.service.card.IWdCardLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("wdCardLevelService")
@Transactional(rollbackFor = Exception.class)
public class WdCardLevelServiceImpl implements IWdCardLevelService {

	@Autowired
	private WdCardLevelMapper wdCardLevelMapper;
	
	@Override
	public int insert(WdCardLevel wdCardLevel) {
		return wdCardLevelMapper.insert(wdCardLevel);
	}

	@Override
	public int selectCountByCondition(Map<String, Object> whereCondition) {
		return wdCardLevelMapper.selectCountByCondition(whereCondition);
	}

	@Override
	public List<Map<String,Object>> getCardLevelByPager(Map<String, Object> whereCondition, Integer offset, int numPerPage) {
		List<Map<String,Object>> wdCardLevelList= wdCardLevelMapper.getCardLevelByPager(whereCondition,offset,numPerPage);
		for(Map<String,Object> map:wdCardLevelList) {
			String level = (String) map.get("level");
			String level_alias = (String) LevelType.getLevelMap().get(level);
			map.put("level_alias", level_alias);
		}
		return wdCardLevelList;
	}

	@Override
	public int updateWdCardLevel(WdCardLevel wdCardLevel) {
		return wdCardLevelMapper.updateByPrimaryKey(wdCardLevel);
	}

	@Override
	public WdCardLevel selectLevelByPrimaryKey(Map<String, Object> whereCondition) {
		return wdCardLevelMapper.selectLevelByPrimaryKey(whereCondition);
	}

	@Override
	public int deleteWdCardLevelByPK(Map<String, Object> whereCondition) {
		return wdCardLevelMapper.deleteLevelByPrimaryKey(whereCondition);
	}

	@Override
	public WdCardLevel selectLevelByCumAmt(Map<String, Object> whereCondition){
		return wdCardLevelMapper.selectLevelByCumAmt(whereCondition);
	}

}
