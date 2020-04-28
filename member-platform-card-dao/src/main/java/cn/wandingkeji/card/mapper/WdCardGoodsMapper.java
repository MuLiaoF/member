package cn.wandingkeji.card.mapper;

import cn.wandingkeji.card.entity.WdCardGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 会员卡商品
 * 
 * @author ws
 *
 */
public interface WdCardGoodsMapper {
	
	int insert(@Param("wdCardGoods") WdCardGoods wdCardGoods);
	
	int updateByPrimaryKey(@Param("wdCardGoods") WdCardGoods wdCardGoods);
	
	WdCardGoods selectByPrimaryKey(int id);
	
	int selectWdCardGoodsCount(@Param("condition") Map<String, Object> whereCondition);
	
	List<WdCardGoods> getWdCardGoodsByPager(@Param("condition") Map<String, Object> whereCondition,
                                            @Param("offset") int offset, @Param("pageSize") int pageSize);

	int updateStatusById(@Param("wdCardGoods") WdCardGoods wdCardGoods);

	List<Map<String, Object>> getGoodsToPhone(@Param("condition") Map<String, Object> whereCondition,
                                              @Param("offset") int offset, @Param("pageSize") int pageSize);
}
