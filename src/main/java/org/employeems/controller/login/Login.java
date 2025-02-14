package org.employeems.controller.login;

import org.employeems.common.constant.MessageConstant;
import org.employeems.common.result.Result;
import org.employeems.entity.DTO.LoginRequest;
import org.employeems.entity.permissions.User;
import org.employeems.service.UserService;
import org.employeems.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Login {
    @Autowired
    private UserService userService;

    @PostMapping
    public Result<String> login(@RequestBody LoginRequest loginRequest){
        String token = userService.login(loginRequest.getUsername(),loginRequest.getPassword());
        return Result.success("登录成功",token);
    }

    @PostMapping("/register")
    public Result<String> register(@RequestBody User user){
        userService.register(user);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }
}
