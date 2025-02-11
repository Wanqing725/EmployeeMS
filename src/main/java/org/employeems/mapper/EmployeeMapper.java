package org.employeems.mapper;

import org.apache.ibatis.annotations.*;
import org.employeems.entity.core.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 新增员工
     * @param employee
     */
    void insert(Employee employee);

    /**
     * 获取所有员工
     * @return
     */
    List<Employee> select();
}
