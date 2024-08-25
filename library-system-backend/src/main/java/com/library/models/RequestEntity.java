package com.library.models;

import com.library.types.BookRequestStatus;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.*;

public class RequestEntity {

    private String requestId;
    private String requestingUUID;
    private String receivingUUID;
    private BookRequestStatus status;

    public RequestEntity(){}

    public RequestEntity(String requestingUUID, String receivingUUID, BookRequestStatus status)
    {
        this.requestId = new ObjectId().toHexString();
        this.receivingUUID = receivingUUID;
        this.requestingUUID = requestingUUID;
        this.status = status;
    }

    public RequestEntity(String requestId, String requestingUUID, String receivingUUID, BookRequestStatus status)
    {
        this.requestId = requestId;
        this.receivingUUID = receivingUUID;
        this.requestingUUID = requestingUUID;
        this.status = status;
    }

    public RequestEntity(Document request)
    {
        requestId = request.getString("_id");
        receivingUUID = request.getString("receivingUUID");
        requestingUUID = request.getString("requestingUUID");
        status = BookRequestStatus.valueOf(request.getString("status"));

    }

    public Document getRequestEntityDocument()
    {
        Map<String, Object> requestEntity = new HashMap<>() {{
            put("_id", requestId);
            put("requestingUUID", receivingUUID);
            put("receivingUUID", requestingUUID);
            put("status", status);
        }};

        Document docRequestEntity = new Document();

        docRequestEntity.putAll(requestEntity);
        return docRequestEntity;

    }


    public String getRequestId() { return requestId; }

    public String getrequestingUUID() { return requestingUUID; }

    public void setrequestingUUID(String requestingUUID) { this.requestingUUID = requestingUUID; }

    public String getreceivingUUID() { return receivingUUID; }

    public void setreceivingUUID(String receivingUUID) { this.receivingUUID = receivingUUID; }

    public BookRequestStatus getStatus() { return status; }

    public void setStatus(BookRequestStatus status) { this.status = status; }

}
