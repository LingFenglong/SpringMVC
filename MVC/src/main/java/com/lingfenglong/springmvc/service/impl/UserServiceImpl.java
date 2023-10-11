package com.lingfenglong.springmvc.service.impl;

import com.lingfenglong.springmvc.entity.UserInfo;
import com.lingfenglong.springmvc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserInfo login(String username, String name) {
        // TODO: 2023/10/8
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhangsan");
        userInfo.setPassword("111111");

        if (userInfo == null) {
            throw new RuntimeException("用户名或密码错误");
        }

        return userInfo;
    }

    @Override
    public List<UserInfo> getUserList(String username) {
        return List.of(
                new UserInfo("1", "zs", "zs"),
                new UserInfo("2", "ls", "ls"),
                new UserInfo("3", "ww", "ww")
        );
    }
}
