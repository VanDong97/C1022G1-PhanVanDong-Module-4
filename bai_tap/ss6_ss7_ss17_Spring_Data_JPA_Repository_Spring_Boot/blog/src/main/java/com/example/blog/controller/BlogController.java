package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String showBlog(@RequestParam(required = false,defaultValue = "")String title, Model model){
        model.addAttribute("blogs",iBlogService.listAll(title));
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String performCreate(@ModelAttribute Blog blog){
        iBlogService.save(blog);
        return "redirect:/blog";
    }
}
