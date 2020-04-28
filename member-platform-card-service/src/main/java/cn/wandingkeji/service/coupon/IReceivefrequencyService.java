package cn.wandingkeji.service.coupon;

import cn.wandingkeji.coupon.entity.WdReceiveFrequency;

import java.util.Map;

/**
 * 领取计次卡基础业务
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
public interface IReceivefrequencyService {
	/**
	 * 查询领卡表,有记录则更新,无记录则创建
	 * @param openid
	 * @param memId 会员编号
	 * @param cardId 
	 * @param mid 商户号
	 * @param code
	 * @param canUseTotal 初始次数
	 * @param cardName 计次卡名称
	 * @return
	 */
	Map<String, Object> receiveFrequency(String openid, int memId, String cardId, int mid, String code,
                                         int canUseTotal, String cardName);
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
	WdReceiveFrequency selectByCardIdCode(String CardId, String code, String openid);
	/**
	 * 添加领取次卡
	 * @param wdReceiveFrequency
	 * @return
	 */
	int  insert(WdReceiveFrequency wdReceiveFrequency);
	/**
	 * 更新领取次卡
	 * @param wdReceiveFrequency
	 * @return
	 */
	int updateById(WdReceiveFrequency wdReceiveFrequency);
	/**
	 * 根据条件删除领取次卡
	 * @param id
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
    Map<String,Object> queryDeatilByCardOpenIdCode(String cardId, String openid, String code);
    
	
}
