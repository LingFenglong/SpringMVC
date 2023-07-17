package com.lingfenglong.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")    // 设置映射请求的请求路径的 初始信息
public class UserController {

    @RequestMapping("/list")
    public String list() {
        return "list";
    }

    @RequestMapping("/success") // 设置映射请求的请求路径的 具体信息
    public String success() {
        return "success";
    }
}
