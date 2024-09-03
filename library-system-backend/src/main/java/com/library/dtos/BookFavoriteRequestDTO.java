package com.library.dtos;

import com.library.models.BookFavoriteEntity;

import java.util.UUID;

public class BookFavoriteRequestDTO {

    public String userId;
    public String bookId;

    public BookFavoriteRequestDTO() {}

    public BookFavoriteRequestDTO(BookFavoriteEntity favorite)
    {
        this.userId = favorite.getUserId();
        this.bookId = favorite.getBookId();
    }

    public BookFavoriteEntity toBookFavoriteEntity()
    {
        return new BookFavoriteEntity(userId, bookId);
    }

    public boolean isValid()
    {
        return userId == null && bookId == null && bookId.isEmpty() ? false : true;
    }

}
