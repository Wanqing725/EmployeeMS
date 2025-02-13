package org.employeems.service;

import org.employeems.entity.core.Employee;

import java.util.List;

public interface EmployeeService {
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

    /**
     * 修改员工信息
     * @param employee
     */
    void update(Employee employee);

    /**
     * 根据id删除员工
     * @param id
     */
    void delete(Long id);
}
