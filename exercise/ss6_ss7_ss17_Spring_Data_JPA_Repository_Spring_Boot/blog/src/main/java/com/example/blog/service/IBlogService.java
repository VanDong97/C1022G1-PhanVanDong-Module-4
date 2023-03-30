package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService {

    Page<Blog> findAll(String title, Pageable pageable);

    void save (Blog blog);

    Blog findById(int id);

    void deleteBlog(Integer id);

    void updateBlog(Blog blog);
}

