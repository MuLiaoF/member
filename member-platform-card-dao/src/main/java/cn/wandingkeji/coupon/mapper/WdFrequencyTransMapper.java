package cn.wandingkeji.coupon.mapper;

import cn.wandingkeji.coupon.entity.WdFrequencyTrans;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 次卡使用明细dao
 * @author Administrator
 *
 */
public interface WdFrequencyTransMapper {
	/**
	 * 根据主键id查询次卡使用明细信息
	 * @param id
	 * @return
	 */
	WdFrequencyTrans selectById(int id);
	WdFrequencyTrans selectByCardId(String cardId);
	WdFrequencyTrans selectByReserve(@Param("reserve") String reserve);
	/**
	 * 添加计次卡(属性)
	 * @param wdFrequencyTrans
	 * @return
	 */
	int  insert(@Param("coupon") WdFrequencyTrans wdFrequencyTrans);
	/**
	 * 更新计次卡(属性)
	 * @param wdFrequencyTrans
	 * @return
	 */
	int updateById(@Param("coupon") WdFrequencyTrans wdFrequencyTrans);
	/**
	 * 根据条件删除计次卡(属性)
	 * @param id
	 * @return
	 */
	int deleteById(int id);
	//查询总订单明细数
    int selectFrequencyTransCount(@Param("condition") Map<String, Object> condition);
    //查看所有订单明细
    List<WdFrequencyTrans> getFrequencyTransByPager(@Param("condition") Map<String, Object> condition,
                                                    @Param("offset") int offset, @Param("pageSize") int pageSize);
	
}
