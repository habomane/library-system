package com.library.models;

import org.bson.types.ObjectId;
import com.library.types.BookGenre;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.*;
import java.awt.print.Book;

public class BookEntity {

    @Field("_id")
    private String bookId;
    private String title;
    private String author;
    private BookGenre genre;
    private String image;
    private String zipcode;
    private String description;
    private boolean available;
    private String ownerUUID;

    public BookEntity() {
    }

    public BookEntity(String title, String author, BookGenre genre, String image, String zipcode,
                      String description, boolean available, String ownerUUID) {
        this.bookId = new ObjectId().toHexString();
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.image = image;
        this.zipcode = zipcode;
        this.description = description;
        this.available = available;
        this.ownerUUID = ownerUUID;
    }

    public BookEntity(String bookId, String title, String author, BookGenre genre, String image, String zipcode,
                      String description, boolean available, String ownerUUID) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.image = image;
        this.zipcode = zipcode;
        this.description = description;
        this.available = available;
        this.ownerUUID = ownerUUID;
    }

    public BookEntity(Document bookDocument) {
        this.bookId = bookDocument.getString("_id");
        this.title = bookDocument.getString("title");
        this.author = bookDocument.getString("author");
        this.image = bookDocument.getString("image");
        this.genre = BookGenre.valueOf(bookDocument.getString("genre"));
        this.zipcode = bookDocument.getString("zipcode");
        this.description = bookDocument.getString("description");
        this.available = bookDocument.getBoolean("available");
        this.ownerUUID = bookDocument.getString("ownerUUID");

    }

    public Document getBookEntityDocument() {
        Map<String, Object> data = new HashMap<>() {{
            put("_id", bookId);
            put("title", title);
            put("author", author);
            put("genre", genre);
            put("image", image);
            put("zipcode", zipcode);
            put("description", description);
            put("available", available);
            put("ownerUUID", ownerUUID);
        }};

        Document newDoc = new Document();
        newDoc.putAll(data);

        return newDoc;

    }


    public String getId() { return bookId;}

    public String getOwnerUUID() { return ownerUUID; }

    public void setOwnerUUID(String ownerUUID) { this.ownerUUID = ownerUUID; }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public BookGenre getGenre()
    {
        return genre;
    }

    public void setGenre(BookGenre genre)
    {
        this.genre = genre;
    }

    public String getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean getAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }


}
