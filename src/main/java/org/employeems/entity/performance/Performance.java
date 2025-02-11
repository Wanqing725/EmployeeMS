package org.employeems.entity.performance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 绩效表实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Performance {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 员工ID
     */
    private Long employeeId;

    /**
     * 考核周期（如：2024Q1）
     */
    private String cycle;

    /**
     * 考核指标（JSON存储多维度指标）
     */
    private Object indicators;

    /**
     * 最终评分
     */
    private BigDecimal score;

    /**
     * 评语
     */
    private String comment;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
