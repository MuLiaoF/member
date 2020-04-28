package cn.wandingkeji.coupon.mapper;

import cn.wandingkeji.coupon.entity.WdBindCode;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 用于绑定核销时code码DAO
 * @author jing_huan
 *
 */
public interface WdBindCodeMapper {
	
	WdBindCode selectById(@Param("id") int id);
	WdBindCode selectByMdCode(@Param("mdCode") String mdCode);
	int insert(@Param("bindCode") WdBindCode bindCode);
	int updateById(@Param("bindCode") WdBindCode bindCode);

    void deleteByMdCode(@Param("mdCode") String mdCode);
}
