package com.ra.demo02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomController {
    @GetMapping
    public String hom() {
        return "home";
    }
}
