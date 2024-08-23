package com.library.services;

import com.library.dtos.BookDTO;
import com.library.models.BookEntity;

import java.util.*;

public interface BookService {

    List<BookDTO> findAll();

    BookDTO find(String id);

    BookDTO post(BookDTO book);


}
