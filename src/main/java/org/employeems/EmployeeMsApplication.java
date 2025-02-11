package org.employeems;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.employeems.mapper") // 指定 Mapper 接口所在的包
public class EmployeeMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeMsApplication.class, args);
    }
}
