package com.library.controllers;

import com.library.dtos.RequestDTO;
import com.library.dtos.RequestRequestDTO;
import com.library.services.BookFavoriteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/favorite")
public class BookFavoriteController {

    private final static Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    private final BookFavoriteService bookFavoriteService;

    public BookFavoriteController(BookFavoriteService bookFavoriteService)
    {
        this.bookFavoriteService = bookFavoriteService;
    }

    // GET

    @GetMapping("/")
    public ResponseEntity getFavorites(@RequestParam(name="UUID", required = false) String uuid)
    {
        try
        {
            List<Map<String, String>> filters = new ArrayList<>();
            if(requesterUUID != null && !requesterUUID.isEmpty()) { filters.add(Collections.singletonMap("requestingUUID", requesterUUID)); }
            if(receiverUUID != null && !receiverUUID.isEmpty()) { filters.add(Collections.singletonMap("receivingUUID", receiverUUID)); }

            List<RequestDTO> response = requestService.findAll(filters);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(response);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getFavorite(@PathVariable String id)
    {
        try
        {
            if(id == null || id.isEmpty()) { throw new ValidationException();}

            RequestDTO response = requestService.find(id);
            if(!response.validateFields()) { throw new EntityNotFoundException(); }

            return ResponseEntity.status(HttpStatus.OK)
                    .body(response);
        }
        catch(ValidationException v)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", "The request ID must be provided within the uri."));
        }
        catch(EntityNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("Error", String.format("ID %s not found", id)));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e.getMessage()));
        }
    }


    // POST

    @PostMapping("/create")
    public ResponseEntity createFavorite(@RequestBody RequestRequestDTO request)
    {
        try
        {
            if(!request.validateFields()) { throw new ValidationException();}
            RequestDTO response = requestService.post(request);

            if(!response.validateFields()) { throw new Exception();}

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);
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



    // DELETE

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable String id)
    {
        try
        {
            if(id == null || id.isEmpty()) { throw new ValidationException(); }

            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(requestService.delete(id));
        }
        catch(ValidationException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", String.format("ID %s cannot be empty." , id)));
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
                    .body(requestService.deleteAll(ids));
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
