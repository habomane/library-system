package com.library.controllers;

import com.library.dtos.BookRequestDTO;
import com.library.services.BookService;
import com.library.dtos.BookDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity getBooks()
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(bookService.findAll());
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getBook(@PathVariable String id)
    {
        try
        {
            BookDTO returnedBook = bookService.find(id);

            if(returnedBook.bookId == null || returnedBook.bookId.isEmpty()) { throw new EntityNotFoundException();}

            return ResponseEntity.status(HttpStatus.OK)
                    .body(returnedBook);
        }
        catch(EntityNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("Error", String.format("ID %s not found.", id)));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e.getMessage()));
        }

    }


    // POST

    @PostMapping("/create")
    public ResponseEntity createBook(@RequestBody BookRequestDTO book)
    {
        try
        {
            if(!book.isValid()) { throw new ValidationException();}
            BookDTO returnedBook = bookService.post(book);

            if(!returnedBook.isValid()) { throw new Exception();}

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
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e.getMessage()));
        }

    }

    @PostMapping("/create/many")
    public ResponseEntity createBook(@RequestBody List<BookRequestDTO> books)
    {
        try
        {
            if(books.size() == 0 || books == null) { throw new ValidationException();}

            List<BookDTO> returnedBooks = bookService.postAll(books);

            if(returnedBooks.size() == 0) { throw new Exception();}

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
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e.getMessage()));
        }
    }


    // PUT


    @PutMapping("/update")
    public ResponseEntity updateBook(@RequestBody BookDTO book)
    {
        try
        {
            if(!book.isValid()) { throw new ValidationException();}
            BookDTO returnedBook = bookService.update(book);

            if(returnedBook == null) { throw new EntityNotFoundException();}

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(returnedBook);
        }
        catch(ValidationException v)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", "Required fields are missing from the request body."));
        }
        catch(EntityNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("Error", String.format("ID %s could not be found.", book.bookId)));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e.getMessage()));
        }

    }


    @PutMapping("/update/many")
    public ResponseEntity updateBooks(@RequestBody List<BookDTO> books)
    {
        try
        {
            if(books.size() == 0) { throw new ValidationException();}
            List<BookDTO> returnedBooks = bookService.updateAll(books);

            if(returnedBooks.size() == 0) { throw new EntityNotFoundException();}

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(returnedBooks);
        }
        catch(ValidationException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", "Request body cannot be empty."));
        }
        catch(EntityNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("Error", "No book IDs were found for the items provided."));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e.getMessage()));
        }
    }


    // DELETE

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable String id)
    {
        try
        {
            if(id == null || id.isEmpty()) { throw new ValidationException(); }

            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(bookService.delete(id));
        }
        catch(ValidationException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", "ID cannot be empty." ));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e.getMessage()));
        }

    }


    @DeleteMapping("/delete/many")
    public ResponseEntity deleteBooks(@RequestBody List<String> ids)
    {
        try
        {
            if(ids.size() == 0) { throw new ValidationException(); }

            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(bookService.deleteAll(ids));
        }
        catch(ValidationException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", "IDs must be provided within a list."));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e.getMessage()));
        }
    }







}
