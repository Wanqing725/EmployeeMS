package org.employeems.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.employeems.common.constant.MessageConstant;
import org.employeems.entity.core.Attendance;
import org.employeems.exception.BaseException;
import org.employeems.mapper.AttendanceMapper;
import org.employeems.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

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

    /**
     * 查询所有考勤记录
     * @return
     */
    public List<Attendance> select() {
        return attendanceMapper.select();
    }

    /**
     * 新增考勤
     */
    public void add(Attendance attendance) {
        // 1. 数据校验
        if (attendance.getEmployeeId() == null) {
            throw new BaseException("员工ID不能为空");
        }
        if (attendance.getDate() == null) {
            throw new BaseException("打卡日期不能为空");
        }
        if (attendance.getClockInTime() == null || attendance.getClockOutTime() == null) {
            throw new BaseException("上下班时间不能为空");
        }
        if (attendance.getLocation() != null) {
            try {
                new ObjectMapper().readTree(attendance.getLocation());
            } catch (Exception e) {
                throw new BaseException("无效的JSON格式: " + attendance.getLocation());
            }
        }

        // 2. 时间处理
        attendance.setCreateTime(LocalDateTime.now());
        attendance.setUpdateTime(LocalDateTime.now());

        // 3. 考勤状态计算
        attendance.setStatus(calculateStatus(attendance));

        // 4. 插入考勤记录
        attendanceMapper.add(attendance);
    }

    /**
     * 根据id删除考勤记录
     * @param ids
     */
    public void delete(Long[] ids) {
        if (ids == null || ids.length == 0) {
            throw new BaseException("参数错误：ids 不能为空");
        }
        attendanceMapper.delete(ids);
    }


    private Integer calculateStatus(Attendance attendance) {
        // 获取打卡的上下班时间
        LocalDateTime clockInTime = attendance.getClockInTime();
        LocalDateTime clockOutTime = attendance.getClockOutTime();

        // 获取打卡日期
        LocalDate date = attendance.getDate();

        // 定义公司规定的上下班时间
        LocalTime workStartTime = LocalTime.of(9, 0); // 上班时间 9:00
        LocalTime workEndTime = LocalTime.of(18, 0); // 下班时间 18:00

        // 判断迟到
        if (clockInTime.toLocalTime().isAfter(workStartTime)) {
            return 1; // 迟到
        }

        // 判断早退
        if (clockOutTime.toLocalTime().isBefore(workEndTime)) {
            return 2; // 早退
        }

        // 判断缺勤
        if (clockInTime.toLocalDate().isAfter(date) || clockOutTime.toLocalDate().isBefore(date)) {
            return 3; // 缺勤
        }

        // 正常
        return 0; // 正常
    }
}
