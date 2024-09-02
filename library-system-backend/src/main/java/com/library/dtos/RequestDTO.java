package com.library.dtos;

import com.library.types.*;
import com.library.models.*;

public class RequestDTO {
    public String requestId;
    public String requestingUserId;
    public String receivingUserId;
    public BookRequestStatus status;
    public String details;
    public String dateCreated;

    public RequestDTO() {}

    public RequestDTO(RequestEntity request)
    {
        this.requestId = request.getRequestId();
        this.receivingUserId = request.getreceivingUserId();
        this.requestingUserId = request.getrequestingUserId();
        this.status = request.getStatus();
        this.details = request.getDetails();
        this.dateCreated = request.getDateCreated();
    }

    public RequestEntity toRequestEntity()
    {
        return new RequestEntity(requestId, requestingUserId, receivingUserId, status, details, dateCreated);
    }

    public boolean isValid()
    {
        return requestingUserId == null || requestingUserId.isEmpty() || receivingUserId == null
                || receivingUserId.isEmpty() || status == null ? false : true;
    }


}
