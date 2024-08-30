package com.library.dtos;

import com.library.models.BookEntity;
import com.library.types.BookGenre;

import java.util.UUID;


public class BookDTO {

    public String bookId;
    public String title;
    public String author;
    public BookGenre genre;
    public String image;
    public  String zipcode;
    public String description;
    public boolean available;
    public String ownerUUID;

    public BookDTO() {}

    public BookDTO(BookEntity book) {

        bookId = book.getId();
        title = book.getTitle();
        author = book.getAuthor();
        genre = book.getGenre();
        image = book.getImage();
        zipcode = book.getZipcode();
        description = book.getDescription();
        available = book.getAvailable();
        ownerUUID = book.getOwnerUUID();
    }

    public BookEntity toBookEntity() {
        return new BookEntity(bookId, title, author, genre, image, zipcode, description, available, ownerUUID);
    }

    public boolean isValid()
    {
        return title == null || title.isEmpty() || author == null || author.isEmpty()
                || ownerUUID == null ? false : true;
    }


}

