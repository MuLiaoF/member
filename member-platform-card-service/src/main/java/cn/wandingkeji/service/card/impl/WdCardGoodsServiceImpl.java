package cn.wandingkeji.service.card.impl;

import cn.wandingkeji.card.entity.WdCardGoods;
import cn.wandingkeji.card.mapper.WdCardGoodsMapper;
import cn.wandingkeji.service.card.IWdCardGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("wdCardGoodsService")
public class WdCardGoodsServiceImpl implements IWdCardGoodsService {
	private static final Logger log = LoggerFactory.getLogger(WdCardGoodsServiceImpl.class);
	@Autowired
	private WdCardGoodsMapper wdCardGoodsMapper ;
	@Override
	public int insert(WdCardGoods wdCardGoods) {
	
		return wdCardGoodsMapper.insert(wdCardGoods);
	}
	@Override
	public int updateByPrimaryKey(WdCardGoods wdCardGoods) {
	
		return wdCardGoodsMapper.updateByPrimaryKey(wdCardGoods);
	}
	@Override
	public WdCardGoods selectByPrimaryKey(int id) {
	
		return wdCardGoodsMapper.selectByPrimaryKey(id);
	}
	@Override
	public int selectWdCardGoodsCount(Map<String, Object> whereCondition) {
	
		return wdCardGoodsMapper.selectWdCardGoodsCount(whereCondition);
	}
	@Override
	public List<WdCardGoods> getWdCardGoodsByPager(Map<String, Object> whereCondition, int offset, int pageSize) {
	
		return wdCardGoodsMapper.getWdCardGoodsByPager(whereCondition, offset, pageSize);
	}
	@Override
	public int updateStatusById(WdCardGoods wdCardGoods) {
	
		return wdCardGoodsMapper.updateStatusById(wdCardGoods);
	}
	@Override
	public List<Map<String, Object>> getGoodsToPhone(Map<String, Object> whereCondition, int offset, int pageSize) {
	
		return wdCardGoodsMapper.getGoodsToPhone(whereCondition, offset, pageSize);
	}
	
}
