package com.books.controller;

import com.books.DTO.BookDTO;
import com.books.DTO.DTOUtilMaper;
import com.books.entity.Book;
import com.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookControllerRest {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public List<BookDTO> bookDTOS() {
        return DTOUtilMaper.bookDTOS(bookService.findAll());
    }

    @GetMapping("/itemSearch")
    public List<BookDTO> loadItems() {
        return DTOUtilMaper.bookDTOS(bookService.findAll());
    }
}
