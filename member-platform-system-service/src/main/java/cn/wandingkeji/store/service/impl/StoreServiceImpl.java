package cn.wandingkeji.store.service.impl;

import cn.wandingkeji.store.entity.Store;
import cn.wandingkeji.store.mapper.StoreMapper;
import cn.wandingkeji.store.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("storeService")
public class StoreServiceImpl implements IStoreService {

	@Autowired
	private StoreMapper storeMapper;

	@Override
	public Store selectById(int id) {
		// TODO Auto-generated method stub
		return storeMapper.selectById(id);
	}

	@Override
	public int insert(Store store) {
		// TODO Auto-generated method stub
		return storeMapper.insert(store);
	}

	@Override
	public int updateById(Store store) {
		// TODO Auto-generated method stub
		return storeMapper.updateById(store);
	}

	@Override
	public List<Map<String, Object>> getWxStoreToPhone(int mid) {
		// TODO Auto-generated method stub
		return storeMapper.getWxStoreToPhone(mid);
	}
	

}
