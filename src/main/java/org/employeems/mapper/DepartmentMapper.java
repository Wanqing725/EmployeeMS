package org.employeems.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.employeems.entity.core.Department;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    /**
     * 获取所有部门
     * @return
     */
    @Select("select * from department")
    List<Department> select();

    /**
     * 新增部门
     * @param department
     */
    void add(Department department);

    Department getDepartmentByName(String name);

    /**
     * 修改部门信息
     * @param department
     */
    void update(Department department);

    /**
     * 批量删除部门
     *
     * @param ids
     * @return
     */
    int delete(Long[] ids);
}
