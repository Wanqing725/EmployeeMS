package org.employeems.mapper;

import org.apache.ibatis.annotations.*;
import org.employeems.entity.core.Attendance;
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

    /**
     * 修改员工信息
     * @param employee
     */
    void update(Employee employee);

    /**
     * 检查员工是否存在
     * @param empno
     * @return
     */

    Employee selectByEmpNo(String empno);

    /**
     * 根据工号删除员工
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id查询员工考勤
     * @param id
     * @return
     */
    @Select("select * from attendance where id = #{id}")
    Attendance selectAttById(Long id);
}
