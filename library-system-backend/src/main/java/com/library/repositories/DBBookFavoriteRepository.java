package com.library.repositories;

import com.library.models.*;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.bson.Document;

import java.util.*;

@Repository
public class DBBookFavoriteRepository implements BookFavoriteRepository{

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    private final MongoClient client;

    private MongoCollection<Document> favoritesCollection;

    public DBBookFavoriteRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        favoritesCollection = client.getDatabase("library-system").getCollection("favorites");
    }

    @Override
    public BookFavoriteEntity find(String id) {
        return null;
    }

    @Override
    public List<BookFavoriteEntity> findAll(Map<String, String> filters) {
        return List.of();
    }

    @Override
    public BookFavoriteEntity save(BookFavoriteEntity bookFavorite) {
        return null;
    }

    @Override
    public Map<String, String> delete(String id) {
        return Map.of();
    }

    @Override
    public List<Map<String, String>> deleteAll(List<String> ids) {
        return List.of();
    }
}
