package com.library.controllers;

import com.library.dtos.*;
import com.library.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RequestController.class);
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

// GET

    @GetMapping("/")
    public ResponseEntity getUsers()
    {
        try
        {
           List<UserDTO> response = userService.findAll();

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
    public ResponseEntity getRequest(@PathVariable String id)
    {
        try
        {
            if(id == null || id.isEmpty()) { throw new ValidationException();}

            UserDTO response = userService.find(id);
            if(!response.isValid()) { throw new EntityNotFoundException(); }

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

    @PostMapping("/create")
    public ResponseEntity createBook(@RequestBody UserRequestDTO request)
    {
        try
        {
            if(!request.isValid()) { throw new ValidationException();}
            UserDTO response = userService.post(request);

            if(!response.isValid()) { throw new Exception();}

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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable String id)
    {
        try
        {
            if(id == null || id.isEmpty()) { throw new ValidationException(); }

            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(userService.delete(id));
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
}
