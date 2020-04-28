package cn.wandingkeji.employee.service.impl;

import cn.wandingkeji.employee.entity.Employee;
import cn.wandingkeji.employee.mapper.EmployeeMapper;
import cn.wandingkeji.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public Employee selectByPrimaryKey(int eid) {
		// TODO Auto-generated method stub
		return employeeMapper.selectByPrimaryKey(eid);
	}

	@Override
	public Employee selectByCondition(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return employeeMapper.selectByCondition(condition);
	}

	@Override
	public int insert(Employee employee) {
		// TODO Auto-generated method stub
		return employeeMapper.insert(employee);
	}

	@Override
	public int updateById(Employee employee) {
		// TODO Auto-generated method stub
		return employeeMapper.updateById(employee);
	}

	@Override
	public Employee selectBySidAndType(int sid, String eType) {
		// TODO Auto-generated method stub
		return employeeMapper.selectBySidAndType(sid, eType);
	}

	@Override
	public List<Employee> listBySid(int sid) {
		return employeeMapper.listBySid(sid);
	}

	@Override
	public Employee getSid(String terminId) {
		return employeeMapper.getSid(terminId);
	}


}
