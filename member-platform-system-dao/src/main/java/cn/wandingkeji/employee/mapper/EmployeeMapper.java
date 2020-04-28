package cn.wandingkeji.employee.mapper;

import cn.wandingkeji.employee.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 会员平台订单DAO
 * @author jing_huan
 *
 */
public interface EmployeeMapper {
	 
	Employee selectByPrimaryKey(@Param("id") int id);
	Employee selectByCondition(@Param("condition") Map<String, Object> condition);
	int insert(@Param("employee") Employee employee);

	int updateById(@Param("employee") Employee employee);
	Employee selectBySidAndType(@Param("sid") int sid, @Param("eType") String eType);

    List<Employee> listBySid(int sid);

    Employee getSid(@Param("terminId") String terminId);
}
