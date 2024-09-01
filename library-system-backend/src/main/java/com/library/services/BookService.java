package com.library.services;

import com.library.dtos.BookDTO;
import com.library.dtos.BookRequestDTO;
import com.library.models.BookEntity;

import java.util.*;

public interface BookService {

    List<BookDTO> findAll(Map<String, String> filter);

    BookDTO find(String id);

    BookDTO post(BookRequestDTO book);

    List<BookDTO> postAll(List<BookRequestDTO> books);

    BookDTO update(BookDTO book);

    List<BookDTO> updateAll(List<BookDTO> books);

    Map<String, String> delete(String id);

    List<Map<String, String>> deleteAll(List<String> ids);



}
