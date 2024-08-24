package com.library.repositories;

import com.library.models.BookEntity;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import jakarta.annotation.PostConstruct;
import com.library.models.*;
import org.springframework.stereotype.Repository;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;
import org.bson.conversions.Bson;
import org.bson.Document;

import javax.print.Doc;
import java.util.*;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
@Repository
public class DBBookRepoistory implements BookRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    private final MongoClient client;
    private MongoCollection<Document> bookCollection;

    public DBBookRepoistory(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        bookCollection = client.getDatabase("library-system").getCollection("books");
    }


    @Override
    public List<BookEntity> findAll() {
        return bookCollection.find().into(new ArrayList<>()).stream().map(BookEntity::new).toList();
    }

    @Override
    public BookEntity findOne(String id) {
        Bson filter = Filters.eq("_id", id);
        return new BookEntity(bookCollection.find(filter).first());
    }

    @Override
    public BookEntity save(BookEntity book) {
        bookCollection.insertOne(book.getBookEntityDocument());
        return book;
    }

    @Override
    public List<BookEntity> saveAll(List<BookEntity> books) {
        bookCollection.insertMany(books.stream().map(BookEntity::getBookEntityDocument).toList());
        return books;
    }

    @Override
    public BookEntity update(BookEntity book) {
        Bson filter = Filters.eq("_id", book.getId());
        UpdateResult result = bookCollection.replaceOne(filter, book.getBookEntityDocument());
        return book;
    }

    @Override
    public List<BookEntity> updateAll(List<BookEntity> books) {
        for(BookEntity book: books)
        {
            this.update(book);
        }
        return books;
    }

    @Override
    public Map<String, String> delete(String id) {
        Bson filter = Filters.eq("_id", id);
        DeleteResult result = bookCollection.deleteOne(filter);
        return result.getDeletedCount() > 0 ? Collections.singletonMap("Message", String.format("ID %s was deleted.", id))
                : Collections.singletonMap("Error", String.format("ID %s does not exist.", id));
    }

    @Override
    public List<Map<String, String>> deleteAll(List<String> ids) {
        List<Map<String, String>> messages = new ArrayList<>();
        for(String id: ids)
        {
            messages.add(this.delete(id));
        }

        return messages;
    }


}
