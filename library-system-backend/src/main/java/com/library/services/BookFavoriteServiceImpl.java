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
        return new BookFavoriteDTO(bookFavoriteRepository.find(id));
    }

    @Override
    public List<BookFavoriteDTO> findAll(List<Map<String, String>> filters) {
        return bookFavoriteRepository.findAll(filters).stream().map(BookFavoriteDTO::new).toList();
    }

    @Override
    public BookFavoriteDTO post(BookFavoriteRequestDTO favorite) {
        return new BookFavoriteDTO(bookFavoriteRepository.save(favorite.toBookFavoriteEntity()));
    }

    @Override
    public Map<String, String> delete(String id) {
        return bookFavoriteRepository.delete(id);
    }

    @Override
    public List<Map<String, String>> deleteAll(List<String> ids) {
        return bookFavoriteRepository.deleteAll(ids);
    }
}
