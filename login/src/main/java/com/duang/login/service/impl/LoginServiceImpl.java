package com.duang.login.service.impl;

import com.duang.login.entity.User;
import com.duang.login.mapper.LoginMapper;
import com.duang.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author duang
 * @date 2020-09-06
 * @Describe
 */
@Service
public class LoginServiceImpl implements LoginService {
    private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    HttpServletRequest request;
    @Autowired
    LoginMapper loginMapper;

    @Override
    public boolean check(String username, String password) {
        User loginer = loginMapper.check(username,password);
        if(null == loginer){
            logger.info("用户【"+username+"】登陆失败，账号或密码错误");
            return false;
        }else{
            logger.info("用户【"+username+"】登陆成功");
            request.getSession().setAttribute("LOGINER",loginer.getUsername());
            return true;
        }
    }
}
