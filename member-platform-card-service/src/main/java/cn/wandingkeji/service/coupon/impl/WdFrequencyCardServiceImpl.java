package cn.wandingkeji.service.coupon.impl;

import cn.wandingkeji.coupon.entity.WdFrequencyCard;
import cn.wandingkeji.coupon.mapper.WdFrequencyCardMapper;
import cn.wandingkeji.service.coupon.IWdFrequencyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 
 * @author jing_huan
 * @date 2019年5月22日
 *
 */
@Service("wdFrequencyCardService")
public class WdFrequencyCardServiceImpl implements IWdFrequencyCardService {
	@Autowired
	private WdFrequencyCardMapper wdFrequencyCardMapper;
	@Override
	public WdFrequencyCard selectById2(int id) {
		
		return wdFrequencyCardMapper.selectById2(id);
	}

	@Override
	public WdFrequencyCard selectByCardId(String cardId) {
		
		return wdFrequencyCardMapper.selectByCardId(cardId);
	}

	@Override
	public int insert(WdFrequencyCard wdFrequencyCard) {
		
		return wdFrequencyCardMapper.insert(wdFrequencyCard);
	}

	@Override
	public int updateById(WdFrequencyCard wdFrequencyCard) {
		
		return wdFrequencyCardMapper.updateById(wdFrequencyCard);
	}

	@Override
	public int deleteById(int id) {
		
		return wdFrequencyCardMapper.deleteById(id);
	}

	@Override
	public WdFrequencyCard selectByCardIdAndOpenid(String cardId, String openid) {
		
		return wdFrequencyCardMapper.selectByCardIdAndOpenid(cardId, openid);
	}

	@Override
	public Map<String, Object> getConsumerByOpenid(int member_id, int mid) {
		return wdFrequencyCardMapper.getConsumerByOpenid(member_id, mid);
	}

	@Override
	public Map<String, Object> getCumTransAmt(int memberId, String card_id, String card_barcode, String name, int mid) {
		return wdFrequencyCardMapper.getCumTransAmt(memberId, card_id, card_barcode, name, mid);
	}

	@Override
	public void updateMemBalance(int mid, int memberId, String card_id, String card_barcode, String name,
			BigDecimal amount) {
		wdFrequencyCardMapper.updateMemBalance(mid, memberId, card_id, card_barcode, name, amount);
	}

	@Override
	public String getCardLevel(int mid, String card_id, String level) {
		return wdFrequencyCardMapper.getCardLevel(mid, card_id, level);
	}

}
