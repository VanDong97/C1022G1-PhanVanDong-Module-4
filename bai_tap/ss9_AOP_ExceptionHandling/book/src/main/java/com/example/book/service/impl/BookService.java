package com.example.book.service.impl;

import com.example.book.dto.BookDTO;
import com.example.book.model.Book;
import com.example.book.repository.IBookRepository;
import com.example.book.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<BookDTO> findAllBook() {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> bookList = iBookRepository.findAll();
        BookDTO bookDTO;
        for (Book book : bookList) {
            bookDTO = new BookDTO();
            BeanUtils.copyProperties(book, bookDTO);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public BookDTO findById(int id) {
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(Objects.requireNonNull(iBookRepository.findById(id).orElse(null)), bookDTO);
        return bookDTO;
    }

    @Override
    public void updateBook(Book book) {
        iBookRepository.save(book);
    }
}
