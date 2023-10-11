package com.lingfenglong.springmvc.controller;

import com.lingfenglong.springmvc.entity.UserInfo;
import com.lingfenglong.springmvc.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserInfo userInfo = userService.login(username, password);
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", userInfo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView list(String username) {
        List<UserInfo> userInfoList = userService.getUserList(username);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userlist");
        modelAndView.addObject("list", userInfoList);
        return modelAndView;
    }
    
    @GetMapping("/add")
    public String add() {
        return "redirect:/user/list";
    }

    @GetMapping("/adduser")
    public String adduser() {
        return "adduser";
    }
}
