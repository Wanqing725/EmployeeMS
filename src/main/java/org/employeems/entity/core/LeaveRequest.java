package org.employeems.entity.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 请假表实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequest {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 员工ID
     */
    private Long employeeId;

    /**
     * 请假类型（0-年假，1-病假...）
     */
    private Long type;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 审批状态（0-待审批，1-通过，2-拒绝）
     */
    private Long status;

    /**
     * 审批人ID
     */
    private Long approverId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
