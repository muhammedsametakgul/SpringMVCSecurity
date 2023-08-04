package com.samet.springmvcsecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){

        return "home";
    }


    @GetMapping("/teachers")
    public String showTeacher(){

        return "teacher";
    }

    @GetMapping("/admin")
    public String showAdmin(){

        return "admin";
    }
}
