package org.employeems.controller.employee;

import org.employeems.common.constant.MessageConstant;
import org.employeems.common.result.Result;
import org.employeems.entity.core.Employee;
import org.employeems.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/emp")
@RestController
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    /**
     * 新增员工
     * @param employee
     * @return
     */
    @PostMapping("/insert")
    public Result<String> insert(@RequestBody Employee employee){
        log.info("新增员工：",employee);
        System.out.println(employee);
        employeeService.insert(employee);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    /**
     * 获取所有员工
     * @return
     */
    @GetMapping("/select")
    public Result<List<Employee>> select(){
        List<Employee> employee = employeeService.select();
        return Result.success(employee);
    }

}
