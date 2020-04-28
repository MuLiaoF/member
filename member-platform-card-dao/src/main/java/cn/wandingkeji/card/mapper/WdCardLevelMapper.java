package cn.wandingkeji.card.mapper;


import cn.wandingkeji.card.entity.WdCardLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * add by 0724
 * @author Csen
 *
 */
public interface WdCardLevelMapper {
	
	/**
	 * 会员卡添加等级
	 * @param wdCardLevel
	 * @return
	 */
	public int insert(@Param("wdCardLevel") WdCardLevel wdCardLevel);

	/**
	 * 查询会员卡数目
	 * @param whereCondition
	 * @return
	 */
	public int selectCountByCondition(@Param("condition") Map<String, Object> whereCondition);
	
	/**
	 * 查询会员卡等级列表
	 * @param whereCondition
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Map<String,Object>> getCardLevelByPager(@Param("condition") Map<String, Object> whereCondition, @Param("offset") Integer offset, @Param("pageSize") int pageSize);

	/**
	 * 修改会员卡等级信息
	 * @param wdCardLevel
	 * @return
	 */
	public int updateByPrimaryKey(@Param("wdCardLevel") WdCardLevel wdCardLevel);
	
	/**
	 * 根据主键查询会员卡信息
	 * @param whereCondition
	 * @return
	 */
	public WdCardLevel selectLevelByPrimaryKey(@Param("condition") Map<String, Object> whereCondition);

	/**
	 * 根据主键删除会员卡信息
	 * @param id
	 * @return
	 */
	public int deleteLevelByPrimaryKey(@Param("condition") Map<String, Object> whereCondition);


	WdCardLevel selectLevelByCumAmt(@Param("condition") Map<String, Object> whereCondition);
}
