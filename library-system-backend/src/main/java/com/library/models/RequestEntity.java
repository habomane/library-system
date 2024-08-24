package com.library.models;

import com.library.types.BookRequestStatus;
import org.bson.Document;

import java.util.*;

public class RequestEntity {

    private String requestId;
    private String requestingOwnerUUID;
    private String recievingOwnerUUID;
    private BookRequestStatus status;

    public RequestEntity(){}

    public RequestEntity(String requestingOwnerUUId, String recievingOwnerUUID, BookRequestStatus status)
    {
        this.recievingOwnerUUID = recievingOwnerUUID;
        this.requestingOwnerUUID = requestingOwnerUUId;
        this.status = status;
    }

    public RequestEntity(String requestId, String requestingOwnerUUId, String recievingOwnerUUID, BookRequestStatus status)
    {
        this.requestId = requestId;
        this.recievingOwnerUUID = recievingOwnerUUID;
        this.requestingOwnerUUID = requestingOwnerUUId;
        this.status = status;
    }

    public RequestEntity(Document request)
    {
        requestId = request.getString("_id");
        recievingOwnerUUID = request.getString("recievingOwnerUUID");
        requestingOwnerUUID = request.getString("requestingOwnerUUID");
        status = BookRequestStatus.valueOf(request.getString("status"));

    }


    public Document getRequestEntityDocument()
    {
        Map<String, Object> requestEntity = new HashMap<>() {{
            put("_id", requestId);
            put("requestingOwnerUUID", recievingOwnerUUID);
            put("recievingOwnerUUID", requestingOwnerUUID);
            put("status", status);
        }};

        Document docRequestEntity = new Document();

        docRequestEntity.putAll(docRequestEntity);

        return docRequestEntity;

    }


    public String getRequestId() { return requestId; }

    public String getRequestingOwnerUUID() { return requestingOwnerUUID; }

    public void setRequestingOwnerUUID(String requestingOwnerUUID) { this.requestingOwnerUUID = requestingOwnerUUID; }

    public String getRecievingOwnerUUID() { return recievingOwnerUUID; }

    public void setRecievingOwnerUUID(String recievingOwnerUUID) { this.recievingOwnerUUID = recievingOwnerUUID; }

    public BookRequestStatus getStatus() { return status; }

    public void setStatus(BookRequestStatus status) { this.status = status; }

}
