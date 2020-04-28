package cn.wandingkeji.employee.api;

import cn.wandingkeji.employee.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@FeignClient("system")
public interface EmployeeApi {

    @GetMapping("/get/employee")
    Employee getEmployee(@RequestParam("terminId")String terminId);
}
