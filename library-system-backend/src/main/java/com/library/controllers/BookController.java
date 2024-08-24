package com.library.controllers;

import com.library.models.BookEntity;
import com.library.services.BookService;
import com.library.dtos.BookDTO;
import jakarta.validation.ValidationException;
import org.bson.types.ObjectId;
import org.springframework.http.RequestEntity;
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
    public ResponseEntity<List<BookDTO>> getBooks()
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getBook(@PathVariable String id)
    {
        try
        {
            BookDTO returnedBook = bookService.find(id);

            if(returnedBook == null) { throw new Exception();}

            return ResponseEntity.status(HttpStatus.OK)
                    .body(returnedBook);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("Error", "Book ID not found."));
        }

    }


    // POST

    @PostMapping("/create")
    public ResponseEntity createBook(@RequestBody BookDTO book)
    {
        try
        {
            if(!book.validateRequiredFields()) { throw new ValidationException();}
            BookDTO returnedBook = bookService.post(book);

            if(returnedBook == null) { throw new Exception();}

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(returnedBook);
        }
        catch(ValidationException v)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", "Required fields are missing from the request body."));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e));
        }

    }

    @PostMapping("/create/many")
    public ResponseEntity createBook(@RequestBody List<BookDTO> books)
    {
        try
        {
            if(books.size() == 0 || books == null) { throw new ValidationException();}

            List<BookDTO> returnedBooks = bookService.postAll(books);

            if(returnedBooks.size() == 0) { throw new ValidationException();}

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(returnedBooks);
        }
        catch(ValidationException v)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", "Request body cannot be empty."));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e));
        }
    }


    // PUT


    @PutMapping("/update")
    public ResponseEntity updateBook(@RequestBody BookDTO book)
    {
        try
        {
            if(!book.validateRequiredFields()) { throw new ValidationException();}
            BookDTO returnedBook = bookService.update(book);

            if(returnedBook == null) { throw new Exception();}

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(returnedBook);
        }
        catch(ValidationException v)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", "Required fields are missing from the request body."));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e));
        }

    }


    @PutMapping("/update/many")
    public ResponseEntity updateBooks(@RequestBody List<BookDTO> books)
    {
        try
        {
            List<BookDTO> returnedBooks = bookService.updateAll(books);

            if(returnedBooks.size() == 0) { throw new Exception();}

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(returnedBooks);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e));
        }
    }


    // DELETE

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable String id)
    {
        try
        {
            if(id == null || id.isEmpty()) { throw new Exception(); }

            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(bookService.delete(id));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", "ID cannot be empty." ));
        }

    }


    @DeleteMapping("/delete/many")
    public ResponseEntity deleteBooks(@RequestBody List<String> ids)
    {
        try
        {
            if(ids.size() == 0) { throw new Exception(); }

            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(bookService.deleteAll(ids));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", "IDs must be provided within a list."));
        }
    }







}
