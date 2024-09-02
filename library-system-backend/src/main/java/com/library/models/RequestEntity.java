package com.library.models;

import com.library.types.BookRequestStatus;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.*;

public class RequestEntity {

    private String requestId;
    private String requestingUserId;
    private String receivingUserId;
    private BookRequestStatus status;
    private String details;
    private String dateCreated;

    public RequestEntity(){}

    public RequestEntity(String requestingUserId, String receivingUserId, BookRequestStatus status, String details)
    {
        this.requestId = new ObjectId().toHexString();
        this.receivingUserId = receivingUserId;
        this.requestingUserId = requestingUserId;
        this.status = status;
        this.details = details;
        this.dateCreated = LocalDateTime.now().toString();
    }

    public RequestEntity(String requestId, String requestingUserId, String receivingUserId, BookRequestStatus status, String details, String dateCreated)
    {
        this.requestId = requestId;
        this.receivingUserId = receivingUserId;
        this.requestingUserId = requestingUserId;
        this.status = status;
        this.details = details;
        this.dateCreated = dateCreated;
    }

    public RequestEntity(Document request)
    {
        if(request == null || request.isEmpty()) { setFieldsEmpty(); return; }
        requestId = request.getString("_id");
        receivingUserId = request.getString("receivingUserId");
        requestingUserId = request.getString("requestingUserId");
        status = BookRequestStatus.valueOf(request.getString("status"));
        details = request.getString("details");
        dateCreated = request.getString("dateCreated");

    }

    public Document getRequestEntityDocument()
    {
        Map<String, Object> requestEntity = new HashMap<>() {{
            put("_id", requestId);
            put("requestingUserId",requestingUserId);
            put("receivingUserId", receivingUserId);
            put("status", status);
            put("details", details);
            put("dateCreated", dateCreated);
        }};

        Document docRequestEntity = new Document();

        docRequestEntity.putAll(requestEntity);
        return docRequestEntity;

    }

    private void setFieldsEmpty()
    {
        this.requestId = "";
        this.receivingUserId = "";
        this.requestingUserId = "";
        this.status = null;
        this.details = "";
        this.dateCreated = "";
    }

    public String getRequestId() { return requestId; }

    public String getrequestingUserId() { return requestingUserId; }

    public void setrequestingUserId(String requestingUserId) { this.requestingUserId = requestingUserId; }

    public String getreceivingUserId() { return receivingUserId; }

    public void setreceivingUserId(String receivingUserId) { this.receivingUserId = receivingUserId; }

    public BookRequestStatus getStatus() { return status; }

    public void setStatus(BookRequestStatus status) { this.status = status; }

    public String getDetails() {return details;}

    public void setDetails(String details) { this.details = details; }

    public String getDateCreated() {return dateCreated;}

    public void setDateCreated(String dateCreated) { this.dateCreated = dateCreated; }

}
