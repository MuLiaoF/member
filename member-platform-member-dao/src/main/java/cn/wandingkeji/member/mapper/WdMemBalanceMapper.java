package cn.wandingkeji.member.mapper;

import cn.wandingkeji.member.entity.WdMemBalance;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 会员余额表 DAO
 * @author jing_huan<br>
 * @Date 2019-05-25
 *
 */
public interface WdMemBalanceMapper {
	/**
	 * 根据主键Id查询会员余额信息
	 * @param id
	 * @return
	 */
	WdMemBalance selectByBalanceId(int id);
	WdMemBalance selectByCondition(@Param("condition") Map<String, Object> condition);
	WdMemBalance selectByMemId(@Param("member_id") String member_id);
	/**
	 * 添加会员账户
	 * @param wdMemBalance
	 * @return
	 */
	int insert(@Param("balance") WdMemBalance wdMemBalance);
	/**
	 * 更新会员账户信息
	 * @param wdMemBalance
	 * @return
	 */
	int updateByBalanceId(@Param("balance") WdMemBalance wdMemBalance);
	/**
	 * 删除会员账户
	 * @param id
	 * @return
	 */
	int deleteByBalanceId(int id);

	/**
	 * 更新会员账户信息
	 * @param wdMemBalance
	 * @return
	 */
	int updateBalanceByMemberId(@Param("balance") WdMemBalance wdMemBalance);


	
}