package com.library.dtos;

import com.library.models.BookEntity;
import com.library.types.BookGenre;


public record BookDTO(
        String title,
        String author,
        BookGenre genre,
        String image,
        String zipcode,
        String description,
        boolean available)
{

    public BookDTO(BookEntity book) {
        this(book.getTitle(), book.getAuthor(),
                book.getGenre(), book.getImage(), book.getZipcode(), book.getDescription(), book.getAvailable());
    }

    public BookEntity toBookEntity() {
        return new BookEntity(title, author, genre, image, zipcode, description, available);
    }
}