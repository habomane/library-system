package com.library.repositories;

import com.library.models.*;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFavoriteRepository {

    BookFavoriteEntity find(String id);

    List<BookFavoriteEntity> findAll(Map<String, String> filters);

    BookFavoriteEntity save(BookFavoriteEntity bookFavorite);

    Map<String, String> delete(String id);

    List<Map<String, String>> deleteAll(List<String> ids);

}
