package com.library.services;

import com.library.dtos.BookFavoriteDTO;
import com.library.dtos.BookFavoriteRequestDTO;
import com.library.repositories.BookFavoriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookFavoriteServiceImpl implements BookFavoriteService{

    private final BookFavoriteRepository bookFavoriteRepository;

    public BookFavoriteServiceImpl(BookFavoriteRepository bookFavoriteRepository) {
        this.bookFavoriteRepository = bookFavoriteRepository;
    }
    @Override
    public BookFavoriteDTO find(String id) {
        return null;
    }

    @Override
    public List<BookFavoriteDTO> findAll(List<Map<String, String>> filters) {
        return List.of();
    }

    @Override
    public BookFavoriteDTO post(BookFavoriteRequestDTO favorite) {
        return null;
    }

    @Override
    public Map<String, String> delete(String id) {
        return Map.of();
    }

    @Override
    public List<Map<String, String>> deleteAll(String ids) {
        return List.of();
    }
}
