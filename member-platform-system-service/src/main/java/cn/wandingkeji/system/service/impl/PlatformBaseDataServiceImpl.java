package cn.wandingkeji.system.service.impl;

import cn.wandingkeji.system.entity.PlatformBaseData;
import cn.wandingkeji.system.mapper.PlatformBaseDataMapper;
import cn.wandingkeji.system.service.IPlatformBaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author jing_huan
 * @Description 获取基础数据
 * @Date 2019年6月6日
 */
@Service("platformBaseDataService")
public class PlatformBaseDataServiceImpl implements IPlatformBaseDataService {

	@Autowired
	private PlatformBaseDataMapper platformBaseDataMapper;

	@Override
	public PlatformBaseData findByDataKey(String dataType) {
		return platformBaseDataMapper.findByDataKey(dataType);
	}
	
}
