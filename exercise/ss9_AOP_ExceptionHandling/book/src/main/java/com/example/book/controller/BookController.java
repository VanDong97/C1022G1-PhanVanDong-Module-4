package com.example.book.controller;

import com.example.book.dto.BookDTO;
import com.example.book.model.Book;
import com.example.book.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    public IBookService ibookService;

    @GetMapping("")
    public String showAllList(Model model) {
        model.addAttribute("bookDTOList", ibookService.findAllBook());
        return "/list";
    }

    @GetMapping("/borrow")
    public String performBorrow (@RequestParam Integer id) {
        BookDTO bookDTO = ibookService.findById(id);
        bookDTO.borrow();
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        ibookService.updateBook(book);
        return "redirect:/book";
    }

    @GetMapping("/giveBack")
    public String performGiveBack (@RequestParam String borrowCode, int id,
                                   RedirectAttributes redirectAttributes)  {
        BookDTO bookDTO = ibookService.findById(id);
        bookDTO.giveBack(borrowCode);
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        ibookService.updateBook(book);
        return "redirect:/book";
    }
}
