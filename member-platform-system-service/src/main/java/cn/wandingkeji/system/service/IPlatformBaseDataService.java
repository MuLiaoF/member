package cn.wandingkeji.system.service;

import cn.wandingkeji.system.entity.PlatformBaseData;

/**
	@author jinghuan 
	@Description 平台基础数据Service
	@Date 2019年6月6日
*/

public interface IPlatformBaseDataService {
	
	/**
	 * 根据key查value
	 * @param dataType
	 * @return
	 */
	PlatformBaseData findByDataKey(String dataType);

}
