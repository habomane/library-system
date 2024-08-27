package com.library.dtos;

import com.library.models.BookEntity;
import com.library.types.BookGenre;

public class BookRequestDTO {

    public String title;
    public String author;
    public BookGenre genre;
    public String image;
    public  String zipcode;
    public String description;
    public boolean available;
    public String ownerUUID;

    public BookRequestDTO() {}


    public BookEntity toBookEntity() {
        return new BookEntity(title, author, genre, image, zipcode, description, available, ownerUUID);
    }

    public boolean validateRequiredFields()
    {
        return title == null || title.isEmpty() && author == null || author.isEmpty()
                || ownerUUID == null || ownerUUID.isEmpty() ? false : true;
    }


}

