package com.library.models;

import org.bson.*;
import org.bson.types.ObjectId;

import java.util.*;

public class BookFavoriteEntity {

    private String bookFavoriteId;
    private String userId;
    private String bookId;

    public BookFavoriteEntity() {}

    public BookFavoriteEntity(String bookFavoriteId, String userId, String bookId)
    {
        this.bookFavoriteId = bookFavoriteId;
        this.userId = userId;
        this.bookId = bookId;
    }

    public BookFavoriteEntity(String userId, String bookId)
    {
        this.bookFavoriteId = new ObjectId().toHexString();
        this.userId = userId;
        this.bookId = bookId;
    }

    public BookFavoriteEntity(Document doc)
    {
        if(doc == null  || doc.isEmpty()) { setFieldsEmpty(); return;}
        this.bookFavoriteId = doc.getString("_id");
        this.userId = doc.getString("userId");
        this.bookId = doc.getString("bookId");
    }

    public Document toBookFavoriteDocument()
    {
        Document bookFavoriteDoc = new Document();

        Map<String, Object> bookFavoriteData = new HashMap<>() {{
            put("_id", bookFavoriteId);
            put("userId", userId);
            put("bookId", bookId);
        }};

        bookFavoriteDoc.putAll(bookFavoriteData);
        return bookFavoriteDoc;
    }

    private void setFieldsEmpty()
    {
        this.bookFavoriteId = "";
        this.userId = "";
        this.bookId = "";
    }

    public String getBookFavoriteId() { return bookFavoriteId; }

    public void setBookFavoriteId(String bookFavoriteId) { this.bookFavoriteId = bookFavoriteId; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getBookId() { return bookId; }

    public void setBookId(String bookId) { this.bookId = bookId; }

}
