package org.employeems.service.impl;

import org.employeems.common.result.Result;
import org.employeems.entity.permissions.User;
import org.employeems.exception.BaseException;
import org.employeems.mapper.UserMapper;
import org.employeems.service.UserService;
import org.employeems.util.JwtUtil;
import org.employeems.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public String login(String username, String password) {
        // 从数据库中查询用户
        User user = userMapper.login(username);

        if (user == null) {
            throw new BaseException("用户名或密码错误");
        }

        // 验证密码
        if (!PasswordUtil.verifyPassword(password, user.getPassword())) {
            throw new BaseException("用户名或密码错误");
        }
        // 生成 Token
        String token = JwtUtil.generateToken(user.getUsername());
        return token;
    }

    public void register(User user) {
        // 数据校验
        if (user == null) {
            throw new BaseException("注册信息不能为空");
        }
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new BaseException("用户名不能为空");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new BaseException("密码不能为空");
        }
        if (user.getEmployeeId() == null) {
            throw new BaseException("员工ID不能为空");
        }

        // 检查用户名是否已存在
        User existingUser = userMapper.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new BaseException("用户名已存在");
        }

        // 加密密码
        String hashedPassword = PasswordUtil.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);

        // 设置默认值
        user.setEnabled(1); // 默认启用
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        int result = userMapper.regist(user);
        if(result <= 0){
            throw new BaseException("注册失败");
        }
    }
}
