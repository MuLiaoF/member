package cn.wandingkeji.service.coupon;

import cn.wandingkeji.coupon.entity.WdFrequencyTrans;

import java.util.List;
import java.util.Map;

/**
 * 计次卡核销基础业务
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
public interface IWdFrequencyTransService {
	/**
	 * 根据主键id查询计次卡核销信息
	 * @param id
	 * @return
	 */
	WdFrequencyTrans selectById(int id);
	/**
	 * 根据主键card_id查询计次卡核销信息
	 * @param cardId
	 * @return
	 */
	WdFrequencyTrans selectByCardId(String cardId);
	WdFrequencyTrans selectByReserve(String reserve);
	/**
	 * 添加计次卡核销记录
	 * @param wdFrequencyTrans
	 * @return
	 */
	int  insert(WdFrequencyTrans wdFrequencyTrans);
//	int  insertTrans(String mid);
	/**
	 * 更新计次卡核销记录
	 * @param wdFrequencyTrans
	 * @return
	 */
	int updateById(WdFrequencyTrans wdFrequencyTrans);
	/**
	 * 根据条件删除计次卡核销记录
	 * @param id
	 * @return
	 */
	int deleteById(int id);
	
	//查询总订单明细数
    int selectFrequencyTransCount(Map<String, Object> condition);
    //查看所有订单明细
    List<WdFrequencyTrans> getFrequencyTransByPager(Map<String, Object> condition,
                                                    int offset, int pageSize);
	
	
	
	
}
