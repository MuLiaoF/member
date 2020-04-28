package cn.wandingkeji.system.mapper;

import cn.wandingkeji.system.entity.PlatformBaseData;

/**
	@author jinghuan 
	@Description 平台基础数据mapper
	@Date 2019年6月6日
*/

public interface PlatformBaseDataMapper {
	
	/**
	 * 根据key查value
	 * @param dataType
	 * @return
	 */
	PlatformBaseData findByDataKey(String dataType);

}
