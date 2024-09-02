package com.library.dtos;

import com.library.models.RequestEntity;
import com.library.types.BookRequestStatus;

public class RequestRequestDTO {
    public String requestingUserId;
    public String receivingUserId;
    public BookRequestStatus status;
    public String details;

    public RequestRequestDTO() {}

    public RequestRequestDTO(RequestEntity request)
    {
        this.receivingUserId = request.getreceivingUserId();
        this.requestingUserId = request.getrequestingUserId();
        this.status = request.getStatus();
        this.details = request.getDetails();
    }

    public RequestEntity toRequestEntity()
    {
        return new RequestEntity(requestingUserId, receivingUserId, status, details);
    }


    public boolean isValid()
    {
        return requestingUserId == null || requestingUserId.isEmpty() || receivingUserId == null
                || receivingUserId.isEmpty() || status == null ? false : true;
    }

}
