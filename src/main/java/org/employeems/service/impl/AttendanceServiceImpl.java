package org.employeems.service.impl;

import org.employeems.common.constant.MessageConstant;
import org.employeems.entity.core.Attendance;
import org.employeems.exception.BaseException;
import org.employeems.mapper.AttendanceMapper;
import org.employeems.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    /**
     * 根据id查询员工考勤记录
     */
    public boolean selectAttendanceById(Long id){
        if(attendanceMapper.selectAttendanceById(id)){
            return true;
        }
        throw new BaseException(MessageConstant.ATTENDANCE_IS_EXISTENT);
    }
}
