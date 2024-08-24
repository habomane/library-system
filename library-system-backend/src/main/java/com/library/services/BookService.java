package com.library.services;

import com.library.dtos.BookDTO;
import com.library.models.BookEntity;

import java.util.*;

public interface BookService {

    List<BookDTO> findAll();

    BookDTO find(String id);

    BookDTO post(BookDTO book);

    List<BookDTO> postAll(List<BookDTO> books);

    BookDTO update(BookDTO book);

    List<BookDTO> updateAll(List<BookDTO> books);

    Map<String, String> delete(String id);

    List<Map<String, String>> deleteAll(List<String> ids);



}
