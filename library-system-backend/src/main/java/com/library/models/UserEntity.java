package com.library.models;

import java.time.LocalDateTime;
import java.util.*;
import org.bson.*;
import org.bson.types.ObjectId;

public class UserEntity {

    private String id;
    private UUID userId;
    private String privateKey;
    private LocalDateTime dateCreation;

    public UserEntity() {}

    public UserEntity(String id, UUID userId, String privateKey, LocalDateTime dateCreation)
    {
        this.id = id;
        this.userId = userId;
        this.privateKey = privateKey;
        this.dateCreation = dateCreation;
    }

    public UserEntity(String privateKey)
    {
        id = new ObjectId().toHexString();
        this.privateKey = privateKey;
        userId = UUID.randomUUID();
        dateCreation = LocalDateTime.now();
    }

    public UserEntity(Document doc)
    {
        id = doc.getString("_id");
        privateKey = doc.getString("privateKey");
        userId = UUID.fromString(doc.getString("userId"));
        dateCreation = LocalDateTime.parse(doc.getString("dateCreation"));

    }

    public Document toDocumentEntity()
    {
        Document doc = new Document();
        Map<String, Object> data = new HashMap<>(){{
            put("_id", id);
            put("privateKey", privateKey);
            put("userId", userId);
            put("dateCreation", dateCreation);
        }};

        doc.putAll(data);
        return doc;
    }

    public UUID getUserId() { return userId; }

    public void setUserId(UUID userId) { this.userId = userId; }

    public String getPrivateKey() { return privateKey; }

    public void setPrivateKey(String privateKey) { this.privateKey = privateKey; }

    public LocalDateTime getDateCreation() { return dateCreation; }

    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }


}
