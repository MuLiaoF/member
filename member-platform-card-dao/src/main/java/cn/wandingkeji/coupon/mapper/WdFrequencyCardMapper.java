package cn.wandingkeji.coupon.mapper;


import cn.wandingkeji.coupon.entity.WdFrequencyCard;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Map;


/**
 * 计次卡属性Dao
 * @author jing_huan
 *
 */
public interface WdFrequencyCardMapper {
	
	/**
	 * 根据主键id查询计次卡属性信息
	 * @param id
	 * @return
	 */
	
	WdFrequencyCard selectById2(int id);
	/**
	 * 根据主键cardId查询计次卡属性信息
	 * @param cardId
	 * @return
	 */
	
	WdFrequencyCard selectByCardId(String cardId);
	WdFrequencyCard selectByCardIdAndOpenid(@Param("cardId") String cardId, @Param("openid") String openid);
	/**
	 * 添加计次卡(属性)
	 * @param wdFrequencyCard
	 * @return
	 */
	int  insert(@Param("coupon") WdFrequencyCard wdFrequencyCard);
	/**
	 * 更新计次卡(属性)
	 * @param wdFrequencyCard
	 * @return
	 */
	int updateById(@Param("coupon") WdFrequencyCard wdFrequencyCard);
	/**
	 * 根据条件删除计次卡(属性)
	 * @param id
	 * @return
	 */
	int deleteById(int id);

	Map<String, Object> getConsumerByOpenid(@Param("member_id") int member_id, @Param("mid") int mid);

	Map<String, Object> getCumTransAmt(@Param("memberId") int memberId, @Param("card_id") String card_id, @Param("card_barcode") String card_barcode, @Param("name") String name, @Param("mid") int mid);

	void updateMemBalance(@Param("mid") int mid, @Param("memberId") int memberId, @Param("card_id") String card_id, @Param("card_barcode") String card_barcode, @Param("name") String name, @Param("amount") BigDecimal amount);
	String getCardLevel(@Param("mid") int mid, @Param("card_id") String card_id, @Param("level") String level);

	// TODO
	//Merchants selectById(@Param("mid") int mid);

	//TODO
	// selectLevelByCumAmt(@Param("condition") Map<String, Object> whereCondition);

	void updateMemberInfo(@Param("memberId") int memberId, @Param("mid") int mid, @Param("currentLevel") String currentLevel, @Param("currLevelName") String currLevelName);
	Map<String, Object> queryPushTokenId(@Param("mid") int mid, @Param("token_type") String token_type);
	Map<String, Object> findByDataKey(@Param("dataKey") String dataKey);
}
