package com.library.controllers;

import com.library.dtos.*;
import com.library.services.RequestService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/request")
public class RequestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RequestController.class);
    private final RequestService requestService;

    public RequestController(RequestService requestService) { this.requestService = requestService; }

    // GET

    @GetMapping("/")
    public ResponseEntity getRequests()
    {
        try
        {
            List<RequestDTO> response = requestService.findAll();
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
    public ResponseEntity createBook(@RequestBody RequestRequestDTO request)
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

    @PostMapping("/create/many")
    public ResponseEntity createBook(@RequestBody List<RequestRequestDTO> requests)
    {
        try
        {
            if(requests.size() == 0 || requests == null) { throw new ValidationException();}

            List<RequestDTO> response = requestService.postAll(requests);

            if(response.size() == 0) { throw new Exception();}

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);
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
    public ResponseEntity updateBook(@RequestBody RequestDTO request)
    {
        try
        {
            if(!request.validateFields()) { throw new ValidationException();}
            RequestDTO response = requestService.update(request);

            if(!response.validateFields()) { throw new Exception();}

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);
        }
        catch(ValidationException v)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error", "Required fields are missing from the request body."));
        }
        catch(EntityNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("Error", String.format("ID %s could not be found.", request.requestId)));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error", "Something went wrong. " + e.getMessage()));
        }

    }


    @PutMapping("/update/many")
    public ResponseEntity updateBooks(@RequestBody List<RequestDTO> requests)
    {
        try
        {
            if(requests.size() == 0) { throw new ValidationException();}
            List<RequestDTO> response = requestService.updateAll(requests);

            if(response.size() == 0) { throw new EntityNotFoundException();}

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);
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
