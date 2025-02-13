package org.employeems.service;

import org.employeems.entity.core.Attendance;

import java.util.List;

public interface AttendanceService {
    /**
     * 获取所有考勤记录
     * @return
     */
    List<Attendance> select();

    /**
     * 新增考勤
     */
    void add(Attendance attendance);

    /**
     * 根据id删除考勤记录
     * @param ids
     */
    void delete(Long[] ids);
}
