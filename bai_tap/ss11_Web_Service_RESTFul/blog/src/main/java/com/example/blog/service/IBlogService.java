package com.example.blog.service;

import com.example.blog.dto.BlogDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<BlogDTO> findAll(Pageable pageable);
    BlogDTO findById(int id);
}
