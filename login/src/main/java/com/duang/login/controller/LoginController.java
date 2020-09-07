package com.duang.login.controller;

import com.duang.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duang
 * @date 2020-09-06
 * @Describe 登陆控制器，登陆、注册、修改密码、注销
 */
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public boolean login(@RequestParam(required = true) String username,@RequestParam(required = true) String password){
        return loginService.check(username,password);
    }

}
