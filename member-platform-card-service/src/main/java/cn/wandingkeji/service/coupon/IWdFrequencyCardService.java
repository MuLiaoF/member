package cn.wandingkeji.service.coupon;

import cn.wandingkeji.coupon.entity.WdFrequencyCard;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 计次卡属性基础业务
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
public interface IWdFrequencyCardService {
	/**
	 * 根据主键id查询计次卡属性信息
	 * @param id
	 * @return
	 */
	WdFrequencyCard selectById2(int id);
	/**
	 * 根据主键card_id查询计次卡属性信息
	 * @param cardId
	 * @return
	 */
	WdFrequencyCard selectByCardId(String cardId);
	WdFrequencyCard selectByCardIdAndOpenid(String cardId, String openid);
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
	
	Map<String, Object> getConsumerByOpenid(int member_id, int mid);

	Map<String, Object> getCumTransAmt(int memberId, String card_id, String card_barcode, String name, int mid);

	void updateMemBalance(int mid, int memberId, String card_id, String card_barcode, String name, BigDecimal amount);
	String getCardLevel(int mid, String card_id, String level);
}
