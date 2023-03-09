package com.example.book.service;

import com.example.book.dto.BookDTO;
import com.example.book.model.Book;

import java.util.List;

public interface IBookService {
    List<BookDTO> findAllBook();
    BookDTO findById(int id);
    void updateBook (Book book);
}
