package com.library.services;

import com.library.dtos.*;
import java.util.*;

public interface BookFavoriteService {

    BookFavoriteDTO find(String id);

    List<BookFavoriteDTO> findAll(Map<String, String> filters);

    BookFavoriteDTO post(BookFavoriteRequestDTO favorite);

    Map<String, String> delete(String id);

    List<Map<String, String>> deleteAll(List<String> ids);

}
