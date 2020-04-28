package cn.wandingkeji.employee.service;

import cn.wandingkeji.employee.entity.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {

	
	Employee selectByPrimaryKey(int eid);
	Employee selectByCondition(Map<String, Object> condition);
	int insert(Employee employee);
	int updateById(Employee employee);
	Employee selectBySidAndType(int sid, String eType);

	List<Employee> listBySid(int sid);

    Employee getSid(String terminId);
}
