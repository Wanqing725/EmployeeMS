package org.employeems.service.impl;

import com.mysql.cj.log.Log;
import org.employeems.common.constant.MessageConstant;
import org.employeems.entity.core.Attendance;
import org.employeems.entity.core.Employee;
import org.employeems.exception.BaseException;
import org.employeems.mapper.AttendanceMapper;
import org.employeems.mapper.EmployeeMapper;
import org.employeems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private AttendanceMapper attendanceMapper;

    /**
     * 新增员工
     * @param employee
     */
    public void insert(Employee employee) {
        if(!selectByEmpNo(employee.getEmpNo())){
            employeeMapper.insert(employee);
        }
        throw new BaseException(MessageConstant.EMPLOYEE_IS_EXISTENT);
    }

    /**
     * 获取所有员工
     * @return
     */
    public List<Employee> select() {
        return employeeMapper.select();
    }

    /**
     * 修改员工信息
     * @param employee
     */
    public void update(Employee employee) {
        if(!selectByEmpNo(employee.getEmpNo())){
            throw new BaseException(MessageConstant.EMPLOYEE_IS_NOT_EXISTENT);
        }
        employeeMapper.update(employee);
    }

    /**
     * 根据id删除员工
     * @param id
     */
    public void delete(Long id) {
        if(selectAttendanceById(id)){
            employeeMapper.delete(id);
        }
    }

    /**
     * 根据工号检查员工是否存在
     */
    private boolean selectByEmpNo(String empno) {
        Employee employee = employeeMapper.selectByEmpNo(empno);
        if(employee == null) {
            return false;
        }
        return true;
    }

    /**
     * 根据id查询员工考勤记录
     */
    public boolean selectAttendanceById(Long id){
        Attendance attendance = employeeMapper.selectAttById(id);
        if(attendance == null){
            return true;
        }
        throw new BaseException(MessageConstant.ATTENDANCE_IS_EXISTENT);
    }

}
