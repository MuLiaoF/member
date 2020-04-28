package cn.wandingkeji.card.mapper;

import cn.wandingkeji.card.entity.MerAndWxcard;
import cn.wandingkeji.card.entity.MiniPrograms;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/*
 * 会员充值订单记录,
 * add by ws
 * 20190705
 */
public interface MerAndWxcardMapper {

	int insert(@Param("merAndWxcard") MerAndWxcard merAndWxcard);

	int updateByPrimaryKey(@Param("merAndWxcard") MerAndWxcard merAndWxcard);

	MerAndWxcard selectByMid(int mid);

    MiniPrograms getMiniProgramsByAppid(@Param("condition") Map<String, Object> condition);
}
