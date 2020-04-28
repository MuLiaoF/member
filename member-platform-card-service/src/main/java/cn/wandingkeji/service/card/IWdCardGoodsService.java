package cn.wandingkeji.service.card;

import cn.wandingkeji.card.entity.WdCardGoods;

import java.util.List;
import java.util.Map;

/**
 * 会员卡商品
 * 2019-05-16
 * @author wangsen
 *
 */
public interface IWdCardGoodsService {

	int insert(WdCardGoods wdCardGoods);
	
	int updateByPrimaryKey(WdCardGoods wdCardGoods);
	
	WdCardGoods selectByPrimaryKey(int id);
	
	int selectWdCardGoodsCount(Map<String, Object> whereCondition);
	
	List<WdCardGoods> getWdCardGoodsByPager(Map<String, Object> whereCondition, int offset, int pageSize);

	int updateStatusById(WdCardGoods wdCardGoods);

	List<Map<String, Object>> getGoodsToPhone(Map<String, Object> whereCondition, int offset, int pageSize);
	
	
}
