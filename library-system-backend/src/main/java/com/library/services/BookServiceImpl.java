package com.library.services;

import com.library.dtos.BookDTO;
import com.library.models.BookEntity;
import com.library.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAll().stream().map(BookDTO::new).toList();
    }
}
