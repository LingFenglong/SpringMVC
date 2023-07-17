package com.lingfenglong.mvc.controller;

import com.lingfenglong.mvc.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testparam")
public class ParamController {
    @RequestMapping("/param")
    public String param() {
        return "param";
    }

    @RequestMapping("/httpServletRequest")
    public String testParamHttpServletRequest(HttpServletRequest request) {
        request.getSession();
        System.out.println(
            "username = " + request.getParameter("username") + "\r\n" +
            "password = " + request.getParameter("password")
        );
        return "success";
    }

    @RequestMapping("/requestParam")
    public String testParamRequestParam(String username, String password) {
        System.out.println(
            "username = " + username + "\r\n" +
            "password = " + password
        );
        return "success";
    }

    @RequestMapping("/paramHeaderCookie")
    public String testParamHeaderCookie(User user,
                                        @RequestHeader String host,
                                        @CookieValue String JSESSIONID) {
        System.out.println(
            "username = " + user.getUsername() + "\r\n" +
            "password = " + user.getPassword() + "\r\n" +
            "host = " + host + "\r\n" +
            "JSESSIONID = " + JSESSIONID
        );
        return "success";
    }
}
