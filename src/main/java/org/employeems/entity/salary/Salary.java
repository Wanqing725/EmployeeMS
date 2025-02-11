package org.employeems.entity.salary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 员工ID
     */
    private Long employeeId;

    /**
     * 发放月份（格式：YYYYMM）
     */
    private String month;

    /**
     * 基本工资
     */
    private java.math.BigDecimal baseSalary;

    /**
     * 绩效奖金
     */
    private BigDecimal bonus;

    /**
     * 社保扣除
     */
    private BigDecimal insurance;

    /**
     * 个税扣除
     */
    private BigDecimal tax;

    /**
     * 实发工资
     */
    private BigDecimal netSalary;

    /**
     * 发放状态（0-未发，1-已发）
     */
    private Long status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
