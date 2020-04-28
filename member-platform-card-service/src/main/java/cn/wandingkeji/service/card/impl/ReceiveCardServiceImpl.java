package cn.wandingkeji.service.card.impl;

import cn.wandingkeji.card.entity.MerAndWxcard;
import cn.wandingkeji.card.entity.WdReceiveCard;
import cn.wandingkeji.card.mapper.WdReceiveCardMapper;
import cn.wandingkeji.comm.enums.AccessTokenType;
import cn.wandingkeji.service.card.IMerAndWxcardService;
import cn.wandingkeji.service.card.IReceiveCardService;
import cn.wandingkeji.token.api.MerTokenApi;
import cn.wandingkeji.token.api.TokenApi;
import cn.wandingkeji.token.entity.AccessToken;
import cn.wandingkeji.token.entity.MerToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 领取会员卡的业务处理
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
@Service("receiveCardService")
public class ReceiveCardServiceImpl implements IReceiveCardService {
	@Autowired
	private WdReceiveCardMapper wdReceiveCardMapper;
	@Autowired
	private TokenApi tokenApi;
	@Autowired
	private IMerAndWxcardService merAndWxcardService;
	@Autowired
	private MerTokenApi merTokenApi;
	@Override
	public WdReceiveCard selectById(int id) {
		// TODO Auto-generated method stub
		return wdReceiveCardMapper.selectById(id);
	}

	@Override
	public int updateById(WdReceiveCard wdReceiveCard) {
		// TODO Auto-generated method stub
		return wdReceiveCardMapper.updateById(wdReceiveCard);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return wdReceiveCardMapper.deleteById(id);
	}

	@Override
	public int insert(WdReceiveCard record) {
		// TODO Auto-generated method stub
		return wdReceiveCardMapper.insert(record);
	}

	@Override
	public int insertSelective(WdReceiveCard record) {
		// TODO Auto-generated method stub
		return wdReceiveCardMapper.insertSelective(record);
	}

	@Override
	public WdReceiveCard selectByUnionId(String unionId, String card_id) {
		// TODO Auto-generated method stub
		return wdReceiveCardMapper.selectByUnionId(unionId,card_id);
	}

	@Override
	public WdReceiveCard selectByCondition(Map<String, Object> whereCondition) {
		// TODO Auto-generated method stub
		return wdReceiveCardMapper.selectByCondition(whereCondition);
	}
	@Override
	public WdReceiveCard getOnlyByUnionidAndAppid(String unionId,String miniAppid) {
		//通过unionId查询mpOpenid
		AccessToken miniAccessToken = tokenApi.getTokenByTypeAndAppid(AccessTokenType.TYPE_7.getType(), miniAppid);
		int tokenId = miniAccessToken.getId();
		MerToken merToken = merTokenApi.getByTokenidAndType(tokenId, String.valueOf(AccessTokenType.TYPE_7.getType()));
		int mid = merToken.getMid();
		
		MerAndWxcard wxcard = merAndWxcardService.selectByMid(mid);
		//通过unionid和cardId才能确定唯一性
		String cardId = wxcard.getWx_card_id();
		return wdReceiveCardMapper.selectByUnionId(unionId,cardId);
	}

	@Override
	public int updateReplaceCard(String cardId, String openid) {
		return wdReceiveCardMapper.updateReplaceCard(cardId,openid);
	}


}


