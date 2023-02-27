package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SandwichController {

    @GetMapping("/save")
    public String showForm() {
        return "/spice";
    }

    @PostMapping("/save")
    public String save(@RequestParam("spice") String spice, Model model) {
        model.addAttribute("listSpice", spice);
        return "/spice";
    }
}
