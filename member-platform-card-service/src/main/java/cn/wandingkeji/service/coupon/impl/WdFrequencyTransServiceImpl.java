package cn.wandingkeji.service.coupon.impl;

import cn.wandingkeji.coupon.entity.WdFrequencyTrans;
import cn.wandingkeji.coupon.entity.WdReceiveFrequency;
import cn.wandingkeji.coupon.mapper.WdFrequencyTransMapper;
import cn.wandingkeji.coupon.mapper.WdReceiveFrequencyMapper;
import cn.wandingkeji.service.coupon.IWdFrequencyTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计次卡核销明细基础业务
 * @author jing_huan
 * @date 2019年5月22日
 *
 */
@Service("wdFrequencyTransService")
public class WdFrequencyTransServiceImpl implements IWdFrequencyTransService {
	@Autowired
	private WdFrequencyTransMapper wdFrequencyTransMapper;
	
	@Autowired
	private WdReceiveFrequencyMapper wdReceiveFrequencyMapper;
	
	/**
	 * 核销计次卡步骤
	 * 
	 * 1.查询领取次卡账户
	 * 2.组装使用明细参数,插入记录
	 * 3.更新次卡账户的剩余次数
	 * @param mid
	 * @param openid
	 * @param encode
	 * @param cardId
	 * @return
	 */
	public Map<String,Object> insertFreTrans(String mid,String openid,String encode,String cardId){
		Map<String,Object> returnMap = new  HashMap<>();
		String code = encode.substring(0, 14);
		String fre = encode.substring(14);
		
		WdReceiveFrequency wRF = wdReceiveFrequencyMapper.selectByCardIdCodeOpenId(cardId, code, openid);
		WdFrequencyTrans wdFreTrans = new WdFrequencyTrans();
		wdFreTrans.setCard_id(cardId);
		wdFreTrans.setCode(code);
		wdFreTrans.setOpenid(openid);
		Integer frequency = Integer.valueOf(fre);
		wdFreTrans.setUse_total(frequency);
		int surplusCount= wRF.getSurplus_total()-frequency;
		wdFreTrans.setSurplus_total(surplusCount);
		
		
		return returnMap;
	}
	
	@Override
	public WdFrequencyTrans selectById(int id) {
		return wdFrequencyTransMapper.selectById(id);
	}

	@Override
	public WdFrequencyTrans selectByCardId(String cardId) {
		return wdFrequencyTransMapper.selectById(0);
	}

	@Override
	public int insert(WdFrequencyTrans wdFrequencyTrans) {
		return wdFrequencyTransMapper.insert(wdFrequencyTrans);
	}

	@Override
	public int updateById(WdFrequencyTrans wdFrequencyTrans) {
		return wdFrequencyTransMapper.updateById(wdFrequencyTrans);
	}

	@Override
	public int deleteById(int id) {
		return wdFrequencyTransMapper.deleteById(id);
	}
	@Override
	public int selectFrequencyTransCount( Map<String, Object> condition) {
		return wdFrequencyTransMapper.selectFrequencyTransCount(condition);
	}
	@Override
	public  List<WdFrequencyTrans> getFrequencyTransByPager(Map<String, Object> condition,
			 int offset, int pageSize) {
		return wdFrequencyTransMapper.getFrequencyTransByPager(condition, offset, pageSize);
	}

	@Override
	public WdFrequencyTrans selectByReserve(String reserve) {
		return wdFrequencyTransMapper.selectByReserve(reserve);
	}

}
