package cn.wandingkeji.token.mapper;

import cn.wandingkeji.token.entity.AccessToken;
import org.apache.ibatis.annotations.Param;

public interface AccessTokenMapper {
	
	AccessToken selectByAppidAndType(@Param("type") int type, @Param("appid") String appid);

    AccessToken getTokenByType(@Param("type") int type);
}
