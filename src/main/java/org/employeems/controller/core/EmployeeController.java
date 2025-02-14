package org.employeems.controller.core;

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

    /**
     * 修改员工信息
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody Employee employee){
        log.info("修改了员工信息",employee);
        employeeService.update(employee);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    /**
     * 根据员工工号删除员工
     */
    @PostMapping("/delete/{id}")
    public Result<String> delete(@PathVariable Long id){
        log.info("删除了员工：",id);
        employeeService.delete(id);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }
}
