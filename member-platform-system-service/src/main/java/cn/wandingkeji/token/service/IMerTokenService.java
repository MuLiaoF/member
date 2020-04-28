package cn.wandingkeji.token.service;

import cn.wandingkeji.token.entity.MerToken;

import java.util.Map;

/**
 * @author 王森
 * @date 2019年5月29日
 *
 */
public interface IMerTokenService {
	MerToken selectByMidAndType(int mid, String tokenType);

	int insert(MerToken merToken);

	/**
	 * 根据主键id查询商户信息
	 * @param id
	 * @return
	 */
	MerToken selectByTokenidAndType(int tokenId, String tokenType);


	public int selectTokenId(Map<String,Object> whereCondition);



}
