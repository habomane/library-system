package com.library.controllers;

import com.library.models.BookEntity;
import com.library.services.BookService;
import com.library.dtos.BookDTO;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

    private final static Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }
    // GET
    @GetMapping("/")
    public List<BookDTO> getBooks()
    {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable String id)
    {
        return bookService.find(id);
    }




    @PostMapping("/create")
    public BookDTO createBook(@RequestBody BookDTO book)
    {
        return bookService.post(book);
    }







}
