package cn.wandingkeji.service.card;

import cn.wandingkeji.card.entity.WdReceiveCard;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 领会员卡业务处理
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
public interface IReceiveCardService {
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
	int updateById(@Param("coupon") WdReceiveCard wdReceiveCard);
	/**
	 * 根据条件删除领取会员卡信息
	 * @param id
	 * @return
	 */
	int deleteById(int id);

	int insert(WdReceiveCard record);

    int insertSelective(WdReceiveCard record);
    WdReceiveCard selectByUnionId(String unionId, String card_id);

    WdReceiveCard selectByCondition(Map<String, Object> whereCondition);
	WdReceiveCard getOnlyByUnionidAndAppid(String unionId, String miniAppid);


	int updateReplaceCard(String cardId, String openid);
}
