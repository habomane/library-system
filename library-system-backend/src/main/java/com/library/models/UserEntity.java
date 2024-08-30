package com.library.models;

import java.time.LocalDateTime;
import java.util.*;
import org.bson.*;
import org.bson.types.ObjectId;

public class UserEntity {

    private String id;
    private String userId;
    private String privateKey;
    private String dateCreation;

    public UserEntity() {}

    public UserEntity(String id, String userId, String privateKey, String dateCreation)
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
        userId = UUID.randomUUID().toString();
        dateCreation = LocalDateTime.now().toString();
    }

    public UserEntity(Document doc)
    {
        if(doc == null || doc.isEmpty()) { setFieldsEmpty(); return; }
        id = doc.getString("_id");
        privateKey = doc.getString("privateKey");
        userId = doc.getString("userId");
        dateCreation = doc.getString("dateCreation");

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

    private void setFieldsEmpty()
    {
        this.id = "";
        this.userId = "";
        this.privateKey = "";
        this.dateCreation = "";
    }

    public String getId() { return id; }

    public String getUserId() { return userId; }

    public void setUserId(UUID userId) { this.userId = userId.toString(); }

    public String getPrivateKey() { return privateKey; }

    public void setPrivateKey(String privateKey) { this.privateKey = privateKey; }

    public String getDateCreation() { return dateCreation; }

    public void setDateCreation(String dateCreation) { this.dateCreation = dateCreation; }


}
