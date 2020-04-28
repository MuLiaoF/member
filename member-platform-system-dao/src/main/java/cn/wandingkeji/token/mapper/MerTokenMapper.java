package cn.wandingkeji.token.mapper;

import cn.wandingkeji.token.entity.MerToken;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface MerTokenMapper {
	
	public int selectTokenId(@Param("condition") Map<String, Object> whereCondition);
	/**
	 * 根据主键id查询商户信息
	 * @param mid tokenType
	 * @return
	 */
	MerToken selectByMidAndType(@Param("mid") int mid, @Param("token_type") String tokenType);


	int insert(@Param("merToken") MerToken merToken);

	MerToken selectByTokenidAndType(@Param("token_id") int token_id, @Param("token_type") String tokenType);

}
