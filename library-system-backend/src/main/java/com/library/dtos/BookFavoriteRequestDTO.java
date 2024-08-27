package com.library.dtos;

import com.library.models.BookFavoriteEntity;

public class BookFavoriteRequestDTO {

    public String uuid;
    public String bookId;

    public BookFavoriteRequestDTO() {}

    public BookFavoriteRequestDTO(BookFavoriteEntity favorite)
    {
        this.uuid = favorite.getUuid();
        this.bookId = favorite.getBookId();
    }

    public BookFavoriteEntity toBookFavoriteEntity()
    {
        return new BookFavoriteEntity(uuid, bookId);
    }

    public boolean isValid()
    {
        return uuid == null && uuid.isEmpty() && bookId == null && bookId.isEmpty() ? false : true;
    }

}
