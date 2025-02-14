package org.employeems.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.employeems.common.constant.MessageConstant;
import org.employeems.entity.core.Department;
import org.employeems.exception.BaseException;
import org.employeems.mapper.DepartmentMapper;
import org.employeems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 获取所有部门
     * @return
     */
    public List<Department> select() {
        return departmentMapper.select();
    }

    /**
     * 新曾部门
     * @param department
     */
    public void add(Department department) {
        //检查部门是否存在
        if(departmentMapper.getDepartmentByName(department.getName()) != null){
            throw new BaseException(MessageConstant.DEPARTMENT_IS_EXISTENT);
        }
        // 设置创建时间和更新时间为当前时间
        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());

        departmentMapper.add(department);
    }

    /**
     * 修改部门信息
     * @param department
     */
    public void update(Department department) {
        if(department.getId() == null){
            throw new BaseException("部门id不能为空");
        }
        department.setUpdateTime(LocalDateTime.now());
        departmentMapper.update(department);
    }

    /**
     * 批量删除部门
     * @param ids
     */
    public void delete(Long[] ids) {
        if(ids.length == 0){
            throw new BaseException("你id呢？？？");
        }

        int result = departmentMapper.delete(ids);
        if (result > 0) {
            log.info("成功删除 {} 个部门", result);
        } else {
            log.error("删除部门失败");
        }
    }


}
