package cn.wandingkeji.service.card;

import cn.wandingkeji.card.entity.WdMemCard;
import com.member.weixin.api.mp.protocol.activation.ActivationMemCardRes;
import com.member.weixin.api.mp.protocol.activation.GetUserInfoRes;

import java.util.Map;

/**
 * 会员卡基础service
 * @author Administrator
 * @date 2019年5月17日
 *
 */
public interface IWdMemCardService {
	
	/**
	 * 根据主键id查询会员卡信息
	 * @param id
	 * @return
	 */
	WdMemCard selectById(int id);
	WdMemCard selectByWxCardId(String wxCardId);
	WdMemCard queryByWxCardId(String wxCardId);
	/**
	 * 更新会员卡信息
	 * @param wdMemCard
	 * @return
	 */
	int updateById(WdMemCard wdMemCard);
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
	int insert(WdMemCard wdMemCard);
	/**
	 * 组装参数,跳去会员卡激活接口
	 * @param cardId
	 * @param code
	 * @param memNum
	 * @param token
	 * @return
	 */
	ActivationMemCardRes activationCard(String cardId, String code, String memNum, String token);
	/**
	 * 激活会员卡
	 * @param requestMap
	 * @param oldUserInfo
	 */
	//Map<String,Object> WdActivationMember(Map<String, Object> requestMap, Map<String, Object> oldUserInfo);
	GetUserInfoRes getUserInfo(String cardId, String code, String token);
}
