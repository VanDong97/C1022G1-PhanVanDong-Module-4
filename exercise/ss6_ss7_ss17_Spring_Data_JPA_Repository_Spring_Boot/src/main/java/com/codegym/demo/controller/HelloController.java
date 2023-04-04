package com.codegym.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("c11")
public class HelloController {

    @GetMapping("/hello")
    public String showPageHello() {
       return "list";
    }



}
