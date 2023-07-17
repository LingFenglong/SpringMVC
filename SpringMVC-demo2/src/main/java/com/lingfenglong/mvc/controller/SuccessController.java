package com.lingfenglong.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SuccessController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = {"success1", "success2"})
    public String success() {
        return "success";
    }

    @RequestMapping(value = "methodget", method = RequestMethod.GET)
    public String methodGET() {
        return "success";
    }

    @RequestMapping(value = "methodpost", method = RequestMethod.POST)
    public String methodPOST() {
        return "success";
    }

    @RequestMapping(value = "params", params = {"username", "password"})    // 必须有username和password属性
    public String params() {
        return "success";
    }

//    @RequestMapping(value = "params", headers = {})
//    public String params() {
//        return "success";
//    }

    // ant
    @RequestMapping(value = {"/ant", "/a?t", "/a*t"})
    public String ant() {
        return "success";
    }

//    @RequestMapping("/**/ant")
//    public String ant() {
//        return "success";
//    }


    @RequestMapping(value = "rest/{username}/{password}")
    public String rest(@PathVariable("username") String username, @PathVariable("password") String password) {
        System.out.println(username + "  " + password);
        return "success";
    }
}
