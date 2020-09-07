package com.duang.login.service;

import com.duang.login.entity.User;

/**
 * @author duang
 * @date 2020-09-06
 * @Describe
 */
public interface LoginService {
    boolean check(String username, String password);
}
