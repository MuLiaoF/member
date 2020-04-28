package cn.wandingkeji.member.mapper;

import cn.wandingkeji.member.entity.WdMemBonus;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 会员积分表 DAO
 * @author jing_huan<br>
 * @Date 2019-05-16
 *
 */
public interface WdMemBonusMapper {
	/**
	 * 根据主键id查询会员积分信息
	 * @param id
	 * @return
	 */
	WdMemBonus selectById(int id);
	WdMemBonus selectByCondition(@Param("condition") Map<String, Object> condition);
	/**
	 * 添加会员积分
	 * @param wdMemBonus
	 * @return
	 */
	int insert(@Param("bonus") WdMemBonus wdMemBonus);
	/**
	 * 更新会员积分信息
	 * @param wdMemBonus
	 * @return
	 */
	int updateById(@Param("bonus") WdMemBonus wdMemBonus);
	/**
	 * 删除会员积分
	 * @param
	 * @return
	 */
	int deleteById(@Param("id") int id);

	WdMemBonus selectByMemId(int member_id);
	
}