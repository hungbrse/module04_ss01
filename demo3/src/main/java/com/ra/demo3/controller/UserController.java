package com.ra.demo3.controller;

import com.ra.demo3.model.Service.UserService;
import com.ra.demo3.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String user(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/index";
    }
    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser( @PathVariable long id) {
        userService.delete(id);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable long id) {
        model.addAttribute("userEdit", userService.findById(id));
        return "user/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("userEdit") User user) {
        userService.save(user);
        return "redirect:/user";
    }
}
