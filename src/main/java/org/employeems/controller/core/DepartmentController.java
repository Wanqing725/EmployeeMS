package org.employeems.controller.core;

import lombok.extern.slf4j.Slf4j;
import org.employeems.common.constant.MessageConstant;
import org.employeems.common.result.Result;
import org.employeems.entity.core.Department;
import org.employeems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/core/dep")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取所有部门
     * @return
     */
    @GetMapping("/select")
    public Result<List<Department>> select(){
        log.info("查询了所有部门");
        List<Department> depList = departmentService.select();
        return Result.success(depList);
    }

    /**
     * 新增部门
     * @param department
     * @return
     */
    @PostMapping("/add")
    public Result<Department> add(@RequestBody Department department){
        log.info("新增了部门：",department);
        departmentService.add(department);
        return Result.success(department);
    }

    /**
     * 修改部门信息
     * @param department
     * @return
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody Department department){
        log.info("修改了部门信息：",department);
        departmentService.update(department);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    /**
     * 根据id删除部门
     */
    @DeleteMapping("/delete")
    public Result<String> delete(@RequestParam("ids") Long[] ids){
        log.info("删除了部门：",ids);
        departmentService.delete(ids);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

}
