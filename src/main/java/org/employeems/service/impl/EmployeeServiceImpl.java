package org.employeems.service.impl;

import org.employeems.entity.core.Employee;
import org.employeems.mapper.EmployeeMapper;
import org.employeems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 新增员工
     * @param employee
     */
    public void insert(Employee employee) {
        employeeMapper.insert(employee);
    }

    /**
     * 获取所有员工
     * @return
     */
    public List<Employee> select() {
        return employeeMapper.select();
    }
}
