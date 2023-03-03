package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> listAll(String title);

    void save (Blog blog);
}
