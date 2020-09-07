package com.duang.login.mapper;

import com.duang.login.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author duang
 * @date 2020-09-06
 * @Describe
 */
@Component
public interface LoginMapper {
    User check(String username, String password);
}
