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
import com.mongodb.internal.bulk.InsertRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.bson.Document;

import java.util.*;

public class DBRequestRepository implements RequestRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    private final MongoClient client;
    private MongoCollection<Document> requestCollection;

    public DBRequestRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        requestCollection = client.getDatabase("library-system").getCollection("requests");
    }

    @Override
    public RequestEntity find(String id) {
        Bson filter = Filters.eq("_id", id);
        return new RequestEntity(requestCollection.find(filter).first());
    }

    @Override
    public List<RequestEntity> findAll() {
        return requestCollection.find().into(new ArrayList<>().stream().map(RequestEntity::new)).stream().toList();
    }

    @Override
    public RequestEntity save(RequestEntity request) {
        InsertOneResult response = requestCollection.insertOne(request.getRequestEntityDocument());
        if(response.wasAcknowledged()) { return request; }
        return new RequestEntity();
    }

    @Override
    public List<RequestEntity> saveAll(List<RequestEntity> requests) {
        InsertManyResult response = requestCollection.insertMany(requests.stream().map(RequestEntity::getRequestEntityDocument).toList());
        if(response.wasAcknowledged()) { return requests; }
        return new ArrayList<>();
    }

    @Override
    public RequestEntity update(RequestEntity request) {
        Bson filter = Filters.eq("_id", request.getRequestId());
        UpdateResult response = requestCollection.replaceOne(filter, request.getRequestEntityDocument());
        if(response.getMatchedCount() > 0) { return request; }

        return new RequestEntity();
    }

    @Override
    public List<RequestEntity> updateAll(List<RequestEntity> requests) {
        List<RequestEntity> responses = new ArrayList<>();

        for(RequestEntity request: requests)
        {
            responses.add(this.update(request));
        }

        return responses;
    }

    @Override
    public Map<String, String> delete(String requestId) {
        Bson filter = Filters.eq("_id", requestId);
        DeleteResult response = requestCollection.deleteOne(filter);

        return response.getDeletedCount() > 0 ? Collections.singletonMap("Message", String.format("ID %s was deleted.", requestId)) :
                Collections.singletonMap("Message", String.format("ID %s was not found", requestId));
    }

    @Override
    public List<Map<String, String> > deleteAll(List<String> requestIds) {
        List<Map<String, String>> response = new ArrayList<>();

        for(String id: requestIds)
        {
            response.add(this.delete(id));
        }

        return response;
    }
}
