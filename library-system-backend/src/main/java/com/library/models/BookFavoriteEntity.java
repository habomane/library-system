package com.library.models;

import org.bson.*;
import org.bson.types.ObjectId;

import java.util.*;

public class BookFavoriteEntity {

    private String bookFavoriteId;
    private String uuid;
    private String bookId;

    public BookFavoriteEntity() {}

    public BookFavoriteEntity(String bookFavoriteId, String uuid, String bookId)
    {
        this.bookFavoriteId = bookFavoriteId;
        this.uuid = uuid;
        this.bookId = bookId;
    }

    public BookFavoriteEntity(String uuid, String bookId)
    {
        this.bookFavoriteId = new ObjectId().toHexString();
        this.uuid = uuid;
        this.bookId = bookId;
    }

    public BookFavoriteEntity(Document doc)
    {
        if(doc == null  || doc.isEmpty()) { setFieldsEmpty(); return;}
        this.bookFavoriteId = doc.getString("_id");
        this.uuid = doc.getString("uuid");
        this.bookId = doc.getString("bookId");
    }

    public Document toBookFavoriteDocument()
    {
        Document bookFavoriteDoc = new Document();

        Map<String, Object> bookFavoriteData = new HashMap<>() {{
            put("_id", bookFavoriteId);
            put("uuid", uuid);
            put("bookId", bookId);
        }};

        bookFavoriteDoc.putAll(bookFavoriteData);
        return bookFavoriteDoc;
    }

    private void setFieldsEmpty()
    {
        this.bookFavoriteId = "";
        this.uuid = "";
        this.bookId = "";
    }

    public String getBookFavoriteId() { return bookFavoriteId; }

    public void setBookFavoriteId(String bookFavoriteId) { this.bookFavoriteId = bookFavoriteId; }

    public String getUuid() { return uuid; }

    public void setUuid(String uuid) { this.uuid = uuid; }

    public String getBookId() { return bookId; }

    public void setBookId(String bookId) { this.bookId = bookId; }

}
