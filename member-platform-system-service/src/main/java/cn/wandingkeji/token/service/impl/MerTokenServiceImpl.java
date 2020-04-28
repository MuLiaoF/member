package cn.wandingkeji.token.service.impl;

import cn.wandingkeji.token.entity.MerToken;
import cn.wandingkeji.token.mapper.MerTokenMapper;
import cn.wandingkeji.token.service.IMerTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("merTokenService")
public class MerTokenServiceImpl implements IMerTokenService {
	
	@Autowired
	private MerTokenMapper merTokenMapper;

	@Override
	public int selectTokenId(Map<String, Object> whereCondition) {
		return merTokenMapper.selectTokenId(whereCondition);
	}

	@Override
	public MerToken selectByMidAndType(int mid, String tokenType) {
		return merTokenMapper.selectByMidAndType(mid, tokenType);
	}

	@Override
	public int insert(MerToken merToken) {
		return merTokenMapper.insert(merToken);
	}

	@Override
	public MerToken selectByTokenidAndType(int token_id, String tokenType) {
		return merTokenMapper.selectByTokenidAndType(token_id, tokenType);
	}
}
