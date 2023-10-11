package com.lingfenglong.springmvc.service;

import com.lingfenglong.springmvc.entity.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo login(String username, String name);

    List<UserInfo> getUserList(String username);
}
