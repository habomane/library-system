package com.library.models;

import org.bson.types.ObjectId;
import com.library.types.BookGenre;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
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
    private String ownerUserId;
    private String dateCreated;

    public BookEntity() {
    }

    public BookEntity(String title, String author, BookGenre genre, String image, String zipcode,
                      String description, boolean available, String ownerUserId) {
        this.bookId = new ObjectId().toHexString();
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.image = image;
        this.zipcode = zipcode;
        this.description = description;
        this.available = available;
        this.ownerUserId = ownerUserId;
        this.dateCreated = LocalDateTime.now().toString();
    }

    public BookEntity(String bookId, String title, String author, BookGenre genre, String image, String zipcode,
                      String description, boolean available, String ownerUserId) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.image = image;
        this.zipcode = zipcode;
        this.description = description;
        this.available = available;
        this.ownerUserId = ownerUserId;
        this.dateCreated = LocalDateTime.now().toString();

    }

    public BookEntity(Document bookDocument) {
        if(bookDocument == null || bookDocument.isEmpty()) { setFieldsEmpty(); return;}
        this.bookId = bookDocument.getString("_id");
        this.title = bookDocument.getString("title");
        this.author = bookDocument.getString("author");
        this.image = bookDocument.getString("image");
        this.genre = BookGenre.valueOf(bookDocument.getString("genre"));
        this.zipcode = bookDocument.getString("zipcode");
        this.description = bookDocument.getString("description");
        this.available = bookDocument.getBoolean("available");
        this.ownerUserId = bookDocument.getString("ownerUserId");
        this.dateCreated = bookDocument.getString("dateCreated");

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
            put("ownerUserId", ownerUserId);
            put("dateCreated", dateCreated);
        }};

        Document newDoc = new Document();
        newDoc.putAll(data);

        return newDoc;

    }


    private void setFieldsEmpty()
    {
        this.bookId = "";
        this.title = "";
        this.author = "";
        this.genre = null;
        this.image = "";
        this.zipcode = "";
        this.description = "";
        this.available = false;
        this.ownerUserId = "";
        this.dateCreated = "";

    }

    public String getId() { return bookId;}

    public String getownerUserId() { return ownerUserId; }

    public void setownerUserId(String ownerUserId) { this.ownerUserId = ownerUserId; }

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

    public String getDateCreated() { return dateCreated; }

    public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated.toString();}


}
