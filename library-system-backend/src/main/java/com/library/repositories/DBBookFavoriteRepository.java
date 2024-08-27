package com.library.repositories;

import com.library.models.*;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
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
        Bson filter = Filters.eq("_id", id);
        return new BookFavoriteEntity(favoritesCollection.find(filter).first());
    }

    @Override
    public List<BookFavoriteEntity> findAll(Map<String, String> filters) {
        if(filters.isEmpty() || filters == null) { return favoritesCollection.find().into(new ArrayList<>()).stream().map(BookFavoriteEntity::new).toList(); }

        String key = filters.keySet().iterator().next();
        String value = filters.values().iterator().next();
        Bson filterRequestData = Filters.eq(key, value);

        return favoritesCollection.find(filterRequestData).into(new ArrayList<>()).stream().map(BookFavoriteEntity::new).toList();
    }

    @Override
    public BookFavoriteEntity save(BookFavoriteEntity bookFavorite) {
        InsertOneResult response = favoritesCollection.insertOne(bookFavorite.toBookFavoriteDocument());
        if(response.wasAcknowledged()) { return bookFavorite; }
        return null;
    }

    @Override
    public Map<String, String> delete(String id) {
        Bson filter = Filters.eq("_id", id);
        DeleteResult response = favoritesCollection.deleteOne(filter);

        return response.getDeletedCount() > 0 ? Collections.singletonMap("Message", String.format("ID %s was deleted.", id)) :
                Collections.singletonMap("Message", String.format("ID %s was not found", id));
    }

    @Override
    public List<Map<String, String>> deleteAll(List<String> ids) {
        List<Map<String, String>> response = new ArrayList<>();

        for(String id: ids)
        {
            response.add(this.delete(id));
        }

        return response;
    }
}
