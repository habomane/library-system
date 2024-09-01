package com.library.repositories;

import java.util.*;

import com.library.models.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {

    List<BookEntity> findAll(Map<String, String> filter);

    BookEntity findOne(String id);

    BookEntity save(BookEntity book);

    List<BookEntity> saveAll(List<BookEntity> books);

    BookEntity update(BookEntity book);

    List<BookEntity> updateAll(List<BookEntity> book);

    Map<String, String> delete(String id);

    List<Map<String, String>> deleteAll(List<String> ids);
}
