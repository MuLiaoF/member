package cn.wandingkeji.card.mapper;

import cn.wandingkeji.card.entity.WdMemCard;
import org.apache.ibatis.annotations.Param;

/**
 * 会员卡 dao
 * @author jing_huan
 *
 */
public interface WdMemCardMapper {
	/**
	 * 根据主键id查询会员卡信息
	 * @param id
	 * @return
	 */
	WdMemCard selectById(int id);
	WdMemCard selectByWxCardId(String id);
	WdMemCard queryByWxCardId(@Param("wxcard_id") String id);
	/**
	 * 更新会员卡信息
	 * @param wdMemCard
	 * @return
	 */
	int updateById(@Param("wdMemCard") WdMemCard wdMemCard);
	/**
	 * 根据条件删除会员卡信息
	 * @param id
	 * @return
	 */
	int deleteById(int id);
	/**
	 * 根据id条件删除会员卡信息
	 * @param wdMemCard
	 * @return
	 */
	int insert(@Param("wdMemCard") WdMemCard wdMemCard);

	/**
	 * 根据门店及商户ID查询规则
	 * @param shopId
	 * @param merchantId
	 * @return
	 */
    //WdMemberWxPush selectBySidAndMid(@Param("sid") Integer shopId, @Param("mid") String merchantId) throws Exception;
}