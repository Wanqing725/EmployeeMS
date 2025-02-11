package org.employeems.entity.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private static final long serialVersionUID = 1L;

    /**
     * 员工id
     */
    private Long id;

    /**
     * 员工工号
     */
    private String empNo;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 性别
     */
    private Boolean gender; // 使用Boolean类型表示性别

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 职位
     */
    private String position;

    /**
     * 入职日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate hireDate;

    /**
     * 在职状态
     */
    private Boolean status; // 使用Boolean类型表示状态

    /**
     * 部门id
     */
    private Long departmentId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
