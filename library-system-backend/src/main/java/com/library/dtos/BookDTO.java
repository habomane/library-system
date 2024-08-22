package com.library.dtos;

import com.library.models.BookEntity;
import com.library.types.BookGenre;


public class BookDTO {
    public String id;
    public String title;
    public String author;
    public BookGenre genre;
    public String image;
    public  String zipcode;
    public String description;
    public boolean available;

    public BookDTO() {}

    public BookDTO(BookEntity book) {
        this.id = book.getId().toHexString();
        title = book.getTitle();
        author = book.getAuthor();
        genre = book.getGenre();
        image = book.getImage();
        zipcode = book.getZipcode();
        description = book.getDescription();
        available = book.getAvailable();
    }

    public BookEntity toBookEntity() {
        return new BookEntity(title, author, genre, image, zipcode, description, available);
    }
}

