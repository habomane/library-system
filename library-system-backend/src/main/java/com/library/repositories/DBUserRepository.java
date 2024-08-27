package com.library.repositories;

import com.library.models.UserEntity;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import jakarta.annotation.PostConstruct;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;

import java.util.*;
import org.bson.*;

@Repository
public class DBUserRepository implements UserRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    private final MongoClient client;
    private MongoCollection<Document> userCollection;

    public DBUserRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        userCollection = client.getDatabase("library-system").getCollection("users");
    }


    @Override
    public UserEntity find(String userId) {
        Bson filter = Filters.eq("userId", userId);
        return new UserEntity(userCollection.find(filter).first());
    }

    @Override
    public List<UserEntity> findAll() {
        return userCollection.find().into(new ArrayList<>()).stream().map(UserEntity::new).toList();
    }

    @Override
    public UserEntity post(UserEntity user) {
        InsertOneResult result = userCollection.insertOne(user.toDocumentEntity());
        if(result.wasAcknowledged()) { return user; }
        return null;
    }

    @Override
    public Map<String, String> delete(String userId) {
        Bson filter = Filters.eq("userId", userId);
        DeleteResult result = userCollection.deleteOne(filter);
        return result.getDeletedCount() > 0 ? Collections.singletonMap("Message", String.format("ID %s was deleted", userId)) :
                Collections.singletonMap("Error", String.format("ID %s could not be found.", userId));

    }
}
