package com.lingfenglong.mvc.controller;

import com.lingfenglong.mvc.bean.Employee;
import com.lingfenglong.mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employee";
    }
    @PostMapping(value = "/employee")
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}/{path}")
    public String getEmployeeById(@PathVariable("id") Integer id,
                                  @PathVariable(value = "path", required = false) String path,
                                  Model model) {
        model.addAttribute("employee", employeeDao.get(id));
        if (StringUtils.hasText(path)) {
            return path;
        } else {
            return "redirect:/index";
        }
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

}
