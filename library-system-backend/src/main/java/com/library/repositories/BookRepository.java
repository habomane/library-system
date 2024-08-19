package com.library.repositories;

import java.util.List;

import com.library.models.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {

    BookEntity save(BookEntity book);

    List<BookEntity> saveAll(List<BookEntity> books);

    List<BookEntity> findAll();

    List<BookEntity> findAll(List<String> ids);

    BookEntity findOne(String id);

    long delete(String id);

    long delete(List<String> ids);

    long deleteAll();

    BookEntity update(BookEntity book);

    long update(List<BookEntity> books);
}
