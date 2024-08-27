package com.library.dtos;

import com.library.models.*;

import java.util.UUID;

public class BookFavoriteDTO {

    public String bookFavoriteId;
    public String uuid;
    public String bookId;

    public BookFavoriteDTO() {}

    public BookFavoriteDTO(BookFavoriteEntity favorite)
    {
        this.bookFavoriteId = favorite.getBookFavoriteId();
        this.uuid = favorite.getUuid();
        this.bookId = favorite.getBookId();
    }

    public BookFavoriteEntity toBookFavoriteEntity()
    {
        return new BookFavoriteEntity(bookFavoriteId, uuid, bookId);
    }

    public boolean isValid()
    {
        return uuid == null && bookId == null && bookId.isEmpty() ? false : true;
    }

}

