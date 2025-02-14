package org.employeems.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.employeems.entity.permissions.User;

@Mapper
public interface UserMapper {
    /**
     * 用户登录
     * @param username
     * @return
     */
    User login(String username);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int regist(User user);

    /**
     * 根据用户名查询用户是否存在
     * @param username
     * @return
     */
    User findByUsername(String username);
}
