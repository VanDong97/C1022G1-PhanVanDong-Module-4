package com.example.blog.controller;

import com.example.blog.dto.BlogDTO;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public Page<BlogDTO> getBlogs(@PageableDefault(size = 2) Pageable pageable) {
        return blogService.findAll(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{id}")
    public BlogDTO getBlogDetail(@PathVariable int id) {
        return blogService.findById(id);
    }
}
