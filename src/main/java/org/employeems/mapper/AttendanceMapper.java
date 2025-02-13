package org.employeems.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.employeems.entity.core.Attendance;

import java.util.List;

@Mapper
public interface AttendanceMapper {
    /**
     * 根据id查询考勤记录
     * @param id
     * @return
     */
    boolean selectAttendanceById(Long id);

    /**
     * 查询所有考勤记录
     * @return
     */
    @Select("select * from attendance")
    List<Attendance> select();

    /**
     * 新增考勤
     * @param attendance
     */
    void add(Attendance attendance);

    /**
     * 根据id删除考勤记录
     * @param ids
     */
    void delete(Long[] ids);



}
