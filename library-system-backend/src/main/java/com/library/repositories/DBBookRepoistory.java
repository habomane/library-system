package com.library.repositories;

import com.library.models.BookEntity;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;
import org.bson.conversions.Bson;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

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
    private MongoCollection<BookEntity> bookCollection;

    public DBBookRepoistory(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        bookCollection = client.getDatabase("library-system").getCollection("books", BookEntity.class);
    }


    @Override
    public BookEntity save(BookEntity book) {
        bookCollection.insertOne(book);
        return book;
    }

//    @Override
//    public List<BookEntity> saveAll(List<BookEntity> books) {
//        return List.of();
//    }

    @Override
    public List<BookEntity> findAll() {
        return bookCollection.find().into(new ArrayList<>());
    }


//    @Override
//    public List<BookEntity> findAll(List<String> ids) {
//        return List.of();
//    }
//
    @Override
    public BookEntity findOne(String id) {
        ObjectId objectId = new ObjectId(id);
        Bson filter = Filters.eq("_id", objectId);
        return bookCollection.find(filter).first();
    }
//
//    @Override
//    public long delete(String id) {
//        return 0;
//    }
//
//    @Override
//    public long delete(List<String> ids) {
//        return 0;
//    }
//
//    @Override
//    public long deleteAll() {
//        return 0;
//    }
//
//    @Override
//    public BookEntity update(BookEntity book) {
//        return null;
//    }
//
//    @Override
//    public long update(List<BookEntity> books) {
//        return 0;
//    }
}
