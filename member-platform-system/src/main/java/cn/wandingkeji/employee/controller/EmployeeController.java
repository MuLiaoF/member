package cn.wandingkeji.employee.controller;

import cn.wandingkeji.employee.entity.Employee;
import cn.wandingkeji.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/get/employee")
    public Employee getSid(String terminId) {
        Employee employee = employeeService.getSid(terminId);
        return employee;
    }

}
