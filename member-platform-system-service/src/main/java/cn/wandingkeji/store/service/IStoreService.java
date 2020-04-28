package cn.wandingkeji.store.service;

import cn.wandingkeji.store.entity.Store;

import java.util.List;
import java.util.Map;

public interface IStoreService {

	
	Store selectById(int id);
	int insert(Store store);
	int updateById(Store store);
	
	List<Map<String,Object>> getWxStoreToPhone(int mid);
}
