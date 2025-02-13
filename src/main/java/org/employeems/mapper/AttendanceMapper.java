package org.employeems.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.employeems.entity.core.Attendance;

@Mapper
public interface AttendanceMapper {
    /**
     * 根据id查询考勤记录
     * @param id
     * @return
     */
    boolean selectAttendanceById(Long id);
}
