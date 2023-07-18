package com.lingfenglong.mvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ScopeController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "Hello, ServletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("testRequestScope", "Hello, ModelAndView");

        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "Hello, Model");

        return "success";
    }

    @RequestMapping("/testMap")
    public String testModel(Map<String, Object> map) {
        map.put("testRequestScope", "Hello, Map");

        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModel(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "Hello, ModelMap");

        return "success";
    }
//    BindingAwareModelMap --> ExtendedModelMap --> ModelMAP --> Map, Model

    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "Hello, Session");

        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope", "Hello, Application");

        return "success";
    }
}
