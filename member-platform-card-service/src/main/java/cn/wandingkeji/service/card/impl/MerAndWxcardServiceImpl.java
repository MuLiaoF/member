package cn.wandingkeji.service.card.impl;

import cn.wandingkeji.card.entity.MerAndWxcard;
import cn.wandingkeji.card.entity.MiniPrograms;
import cn.wandingkeji.card.mapper.MerAndWxcardMapper;
import cn.wandingkeji.service.card.IMerAndWxcardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("merAndWxcardService")
public class MerAndWxcardServiceImpl implements IMerAndWxcardService {

	private static final Logger log = LoggerFactory.getLogger(MerAndWxcardServiceImpl.class);
	@Autowired
	private MerAndWxcardMapper merAndWxcardMapper;
	@Override
	public int insert(MerAndWxcard merAndWxcard) {
		
		return merAndWxcardMapper.insert(merAndWxcard);
	}
	@Override
	public int updateByPrimaryKey(MerAndWxcard merAndWxcard) {
		
		return merAndWxcardMapper.updateByPrimaryKey(merAndWxcard);
	}
	@Override
	public MerAndWxcard selectByMid(int mid) {
		
		return merAndWxcardMapper.selectByMid(mid);
	}

	@Override
	public MiniPrograms getMiniProgramsByAppid(Map<String, Object> condition) {
		return merAndWxcardMapper.getMiniProgramsByAppid(condition);
	}

}
