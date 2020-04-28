package cn.wandingkeji.card.mapper;

import cn.wandingkeji.card.entity.WdReceiveCard;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 领取会员卡DAO
 * @author jing_huan
 *
 */
public interface WdReceiveCardMapper {
	/**
	 * 根据主键id查询领取会员卡信息
	 * @param id
	 * @return
	 */
	WdReceiveCard selectById(int id);
	/**
	 * 更新领取会员卡信息
	 * @param wdReceiveCard
	 * @return
	 */
	int updateById(@Param("card") WdReceiveCard wdReceiveCard);
	/**
	 * 根据条件删除领取会员卡信息
	 * @param id
	 * @return
	 */
	int deleteById(int id);

	int insert(@Param("card") WdReceiveCard record);

    int insertSelective(WdReceiveCard record);
    WdReceiveCard selectByUnionId(@Param("unionid") String unionid, @Param("card_id") String card_id);

    WdReceiveCard selectByCondition(@Param("condition") Map<String, Object> whereCondition);

    int updateReplaceCard(@Param("cardId") String cardId, @Param("openId") String openid);
}