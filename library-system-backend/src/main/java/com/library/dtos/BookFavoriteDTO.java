package com.library.dtos;

import com.library.models.*;

import java.util.UUID;

public class BookFavoriteDTO {

    public String bookFavoriteId;
    public String userId;
    public String bookId;

    public BookFavoriteDTO() {}

    public BookFavoriteDTO(BookFavoriteEntity favorite)
    {
        this.bookFavoriteId = favorite.getBookFavoriteId();
        this.userId = favorite.getUserId();
        this.bookId = favorite.getBookId();
    }

    public BookFavoriteEntity toBookFavoriteEntity()
    {
        return new BookFavoriteEntity(bookFavoriteId, userId, bookId);
    }

    public boolean isValid()
    {
        return userId == null && bookId == null && bookId.isEmpty() ? false : true;
    }

}

