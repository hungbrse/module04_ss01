package com.ra.demo02.controller;

import com.ra.demo02.module.entity.Employees;
import com.ra.demo02.module.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String employee(Model model) {
        List<Employees> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee/index";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employees());
        return "employee/add";
    }

    @PostMapping("/add")
    public String addEmployee( @ModelAttribute("employee") Employees employee) {
        employeeService.save(employee);
        return "redirect:/employee";

    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.delete(id);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable long id, Model model) {
        Employees editEmployee = employeeService.findById(id);
        model.addAttribute("editEmployee", editEmployee);
        return "employee/edit";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee( @ModelAttribute("editEmployee") Employees editEmployee) {
        employeeService.save(editEmployee);
        return "redirect:/employee";
    }
    @PostMapping("/search")
    public String searchEmployee(@RequestParam("keyWord") String keyword, Model model) {
        List<Employees> employees = employeeService.findByName(keyword);
        model.addAttribute("employees", employees);
        return "employee/index";
    }

}
