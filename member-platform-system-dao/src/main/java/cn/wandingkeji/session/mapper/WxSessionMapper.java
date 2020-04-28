package cn.wandingkeji.session.mapper;

import cn.wandingkeji.session.entity.WxSession;

import java.util.Map;

public interface WxSessionMapper {
	int deleteByPrimaryKey(WxSession key);

	int insert(WxSession record);

	int insertSelective(WxSession record);

	WxSession selectByPrimaryKey(WxSession key);

	WxSession selectByAppIdAndOpenId(Map<String, Object> record); 
	
	WxSession selectBySession(Map<String, Object> record); 

	int updateByPrimaryKeySelective(WxSession record);

	int updateByPrimaryKey(WxSession record);
	
	int updateByAppIdAndOpenId(Map<String, Object> record);

	Map<String, Object> findWxSessionByMiniOpenId(Map<String, Object> condition);
}