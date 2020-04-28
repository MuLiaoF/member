package cn.wandingkeji.service.card;

import cn.wandingkeji.card.entity.WdCardLevel;

import java.util.List;
import java.util.Map;

public interface IWdCardLevelService {

	int insert(WdCardLevel wdCardLevel);

	int selectCountByCondition(Map<String, Object> whereCondition);

	List<Map<String,Object>> getCardLevelByPager(Map<String, Object> whereCondition, Integer offset, int numPerPage);

	int updateWdCardLevel(WdCardLevel wdCardLevel);

	WdCardLevel selectLevelByPrimaryKey(Map<String, Object> whereCondition);

	int deleteWdCardLevelByPK(Map<String, Object> whereCondition);

	WdCardLevel selectLevelByCumAmt(Map<String, Object> whereCondition);
}
