package org.employeems.service;

import org.employeems.entity.core.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    /**
     * 获取所有部门
     * @return
     */
    List<Department> select();

    /**
     * 新增部门
     * @param department
     */
    void add(Department department);

    /**
     * 修改部门信息
     * @param department
     */
    void update(Department department);

    /**
     * 根据id批量删除部门
     * @param ids
     */
    void delete(Long[] ids);
}
