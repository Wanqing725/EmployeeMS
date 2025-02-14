package org.employeems.service;

import org.employeems.entity.permissions.User;

public interface UserService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 用户注册
     * @param user
     */
    void register(User user);
}
