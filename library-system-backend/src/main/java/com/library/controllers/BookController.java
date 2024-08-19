package com.library.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    // Example Request
    @RequestMapping("/hello")
    public String sayHi()
    {
        return "Hi!";
    }

    @RequestMapping(method=RequestMethod.POST, value="/text")
    public String returnData(@RequestBody String text)
    {
        return text;
    }



}
