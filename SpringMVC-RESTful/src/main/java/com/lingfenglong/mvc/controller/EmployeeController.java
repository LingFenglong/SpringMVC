package com.lingfenglong.mvc.controller;

import com.lingfenglong.mvc.bean.Employee;
import com.lingfenglong.mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class EmployeeController {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getALlEmployee(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        employees.forEach(System.out::println);
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employee_list";
    }
}
