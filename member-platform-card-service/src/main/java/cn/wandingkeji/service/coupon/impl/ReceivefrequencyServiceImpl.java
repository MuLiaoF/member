package cn.wandingkeji.service.coupon.impl;

import cn.wandingkeji.common.utils.WriteOff;
import cn.wandingkeji.coupon.entity.WdReceiveFrequency;
import cn.wandingkeji.coupon.mapper.WdReceiveFrequencyMapper;
import cn.wandingkeji.service.coupon.IReceivefrequencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 领取次卡实现类
 * 
 * @author jing_huan
 *
 */
@Slf4j
@Service("receivefrequencyService")
public class ReceivefrequencyServiceImpl implements IReceivefrequencyService {
	@Autowired
	private WdReceiveFrequencyMapper wdReceiveFrequencyMapper;

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
	public Map<String, Object> receiveFrequency(String openid, int memId, String cardId, int mid, String code,
			int canUseTotal,String cardName) {
		log.info("领次卡入参****openid="+openid+" cardId="+cardId+" code="+code+" canUseTotal="+canUseTotal);
		
		WdReceiveFrequency wrf = selectByCardIdCode(cardId, code, openid);
		WdReceiveFrequency wrf2 = new WdReceiveFrequency();
		if(wrf != null) {
			wrf2.setId(wrf.getId());
			wrf2.setSurplus_total(wrf.getSurplus_total()+canUseTotal);
			updateById(wrf2);
		}else {
			wrf2.setSurplus_total(canUseTotal);
			wrf2.setStatus(WriteOff.STA2.getSta());
			wrf2.setOpenid(openid);
			wrf2.setCard_id(cardId);
			wrf2.setCode(code);
			wrf2.setCard_name(cardName);
			wrf2.setMid(mid);
			wrf2.setMem_id(memId);
			insert(wrf2);
		}
		
		
		return null;
	}

	@Override
	public WdReceiveFrequency selectById(int id) {
		return wdReceiveFrequencyMapper.selectById(id);
	}

	/**
	 * 根据CardId查询领取次卡信息
	 * 
	 * @param CardId
	 * @return
	 */
	public WdReceiveFrequency selectByCardIdCode(String CardId,String code,String openid) {
		return wdReceiveFrequencyMapper.selectByCardIdCodeOpenId(CardId, code, openid);
	}

	@Override
	public int insert(WdReceiveFrequency wdReceiveFrequency) {
		
		return wdReceiveFrequencyMapper.insert(wdReceiveFrequency);
	}

	@Override
	public int updateById(WdReceiveFrequency wdReceiveFrequency) {
		
		return wdReceiveFrequencyMapper.updateById(wdReceiveFrequency);
	}

	@Override
	public int deleteById(int id) {
		
		return wdReceiveFrequencyMapper.deleteById(id);
	}

	@Override
	public Map<String, Object> queryDeatilByCardOpenIdCode(String cardId, String openid, String code) {
		
		return wdReceiveFrequencyMapper.queryDeatilByCardOpenIdCode(cardId, openid, code);
	}

}
