package cn.wandingkeji.coupon.mapper;


import cn.wandingkeji.coupon.entity.WdReceiveFrequency;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 领取次卡dao
 * @author jing_huan
 *
 */
public interface WdReceiveFrequencyMapper {
	/**
	 * 根据主键id查询领取次卡信息
	 * @param id
	 * @return
	 */
	WdReceiveFrequency selectById(int id);
	/**
	 * 根据CardId查询领取次卡信息
	 * @param CardId
	 * @return
	 */
	WdReceiveFrequency selectByCardIdCodeOpenId(@Param("cardId") String cardId, @Param("code") String code, @Param("openid") String openid);
	List<WdReceiveFrequency> selectByContidion(@Param("condition") Map<String, Object> contidion);
	int selectFrequencyCount(@Param("condition") Map<String, Object> contidion);
	List<WdReceiveFrequency> getFrequencyByPager(@Param("condition") Map<String, Object> contidion, @Param("offset") int offset, @Param("pageSize") int pageSize);

	/**
	 * 添加领取次卡
	 * @param wdPlatformCoupon
	 * @return
	 */
	int  insert(@Param("coupon") WdReceiveFrequency wdReceiveFrequency);
	/**
	 * 更新领取次卡
	 * @param wdPlatformCoupon
	 * @return
	 */
	int updateById(@Param("coupon") WdReceiveFrequency wdReceiveFrequency);
	/**
	 * 根据条件删除领取次卡
	 * @param couponMap
	 * @return
	 */
	int deleteById(int id);
	 /**
     * 查询领取次卡详情和卡属性
     * @param cardId
     * @param openid
     * @param code
     * @return
     */
    Map<String,Object> queryDeatilByCardOpenIdCode(@Param("cardId") String cardId, @Param("openid") String openid, @Param("code") String code);
    
	
}
