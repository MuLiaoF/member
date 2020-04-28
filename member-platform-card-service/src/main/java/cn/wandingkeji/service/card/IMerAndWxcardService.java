package cn.wandingkeji.service.card;

import cn.wandingkeji.card.entity.MerAndWxcard;
import cn.wandingkeji.card.entity.MiniPrograms;

import java.util.Map;

public interface IMerAndWxcardService {

	int insert(MerAndWxcard merAndWxcard);
	
	int updateByPrimaryKey(MerAndWxcard merAndWxcard);
	
	MerAndWxcard selectByMid(int mid);


    MiniPrograms getMiniProgramsByAppid(Map<String, Object> condition);
}
