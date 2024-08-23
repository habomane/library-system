package com.library.repositories;

import java.util.List;

import com.library.models.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {

    List<BookEntity> findAll();

    BookEntity findOne(String id);

    BookEntity save(BookEntity book);

    List<BookEntity> saveAll(List<BookEntity> books);

    BookEntity update(BookEntity book);

    List<BookEntity> updateAll(List<BookEntity> book);

    String delete(String id);

    List<String> deleteAll(List<String> ids);
}
