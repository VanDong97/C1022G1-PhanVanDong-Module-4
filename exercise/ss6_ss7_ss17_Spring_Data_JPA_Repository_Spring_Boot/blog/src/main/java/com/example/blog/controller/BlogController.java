package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;


    @GetMapping("")
    public String showBlogList(@RequestParam(required = false)String title, Model model,
                          @PageableDefault (size = 2)Pageable pageable){
        if (title == null){
            title = "";
        }
        Sort sort = Sort.by("id").descending();
        Pageable sortPageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),sort);
        Page<Blog> blogs = iBlogService.findAll(title,sortPageable);
        model.addAttribute("blogList",blogs);
        model.addAttribute("title",title);

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < blogs.getTotalPages(); i++) {
            integers.add(i);
        }
        model.addAttribute("integers", integers);
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate( Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String performCreate(@ModelAttribute Blog blog){
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String showBlogDetail (@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/detail";
    }

    @GetMapping("/delete")
    public String performDelete (@RequestParam Integer deleteId) {
        iBlogService.deleteBlog(deleteId);
        return "redirect:/blog";
    }

    @GetMapping("/edit")
    public String showUpdateForm (@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String performUpdate (@ModelAttribute Blog blog) {
        iBlogService.updateBlog(blog);
        return "redirect:/blog";
    }
}
