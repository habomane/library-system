package com.library.services;

import com.library.dtos.BookDTO;
import com.library.dtos.BookRequestDTO;
import com.library.models.BookEntity;
import com.library.repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO find(String id)
    {
        BookDTO newBook = new BookDTO(bookRepository.findOne(id));
        return newBook;
    }

    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAll().stream().map(BookDTO:: new).toList();
    }

    @Override
    public BookDTO post(BookRequestDTO newBook)
    {
          //  if(newBook.title == null || newBook.author == null) { throw new Exception("No title and/or no author provided");}
            BookEntity createdBookEntity = bookRepository.save(newBook.toBookEntity());
            return new BookDTO(createdBookEntity);

    }

    @Override
    public List<BookDTO> postAll(List<BookRequestDTO> books) {
        return bookRepository.saveAll(books.stream().map(BookRequestDTO::toBookEntity).toList()).stream().map(BookDTO::new).toList();
    }

    @Override
    public BookDTO update(BookDTO book) {
        return new BookDTO(bookRepository.update(book.toBookEntity()));
    }

    @Override
    public List<BookDTO> updateAll(List<BookDTO> books) {
        return bookRepository.updateAll(books.stream().map(BookDTO::toBookEntity).toList()).stream().map(BookDTO::new).toList();
    }

    @Override
    public Map<String, String> delete(String id) {
        return bookRepository.delete(id);
    }

    @Override
    public List<Map<String, String>> deleteAll(List<String> ids) {
        return bookRepository.deleteAll(ids);
    }


}
