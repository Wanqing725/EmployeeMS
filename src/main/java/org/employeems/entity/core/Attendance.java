package org.employeems.entity.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 员工ID
     */
    private Long employeeId;

    /**
     * 打卡日期
     */
    private LocalDateTime date;

    /**
     * 上班时间
     */
    private LocalDateTime clockInTime;

    /**
     * 下班时间
     */
    private LocalDateTime clockOutTime;

    /**
     * 状态（0-正常，1-迟到，2-早退，3-缺勤）
     */
    private Long status;

    /**
     * 地理位置（经纬度）
     */
    private Object location;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
