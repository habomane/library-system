package com.library.services;

import com.library.dtos.BookDTO;
import com.library.models.BookEntity;
import com.library.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> findAll() {
        List<BookDTO> test = new ArrayList<>();
        List<BookEntity> all = bookRepository.findAll().stream().toList();
        for(BookEntity book : all)
        {
            test.add(new BookDTO(book));
        }

        return test;
    }

    @Override
    public BookDTO post(BookDTO newBook)
    {

//            if(newBook.title == null || newBook.author == null) { throw new Exception("No title and/or no author provided");}
            BookEntity createdBookEntity = bookRepository.save(newBook.toBookEntity());
            return new BookDTO(createdBookEntity);


    }

    @Override
    public BookDTO find(String id)
    {
        BookDTO newBook = new BookDTO(bookRepository.findOne(id));
        return newBook;
    }


}
