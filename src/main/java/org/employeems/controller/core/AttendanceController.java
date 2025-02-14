package org.employeems.controller.core;

import org.employeems.common.constant.MessageConstant;
import org.employeems.common.result.Result;
import org.employeems.entity.core.Attendance;
import org.employeems.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core/attend")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    /**
     * 查询所有考勤记录
     * @return
     */
    @GetMapping("/select")
    public Result<List<Attendance>> select(){
        List<Attendance> attendList = attendanceService.select();
        return Result.success(attendList);
    }

    /**
     * 新增考勤
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody Attendance attendance){
        attendanceService.add(attendance);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    /**
     * 根据id删除考勤记录(可批量删除)
     */
    @PostMapping("/delete")
    public Result<String> delete(@RequestBody Long[] ids) {
        attendanceService.delete(ids);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }
}
