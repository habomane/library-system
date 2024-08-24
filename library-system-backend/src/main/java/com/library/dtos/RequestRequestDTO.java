package com.library.dtos;

import com.library.models.RequestEntity;
import com.library.types.BookRequestStatus;

public class RequestRequestDTO {
    public String requestingOwnerUUID;
    public String recievingOwnerUUID;
    public BookRequestStatus status;

    public RequestRequestDTO() {}

    public RequestRequestDTO(RequestEntity request)
    {
        this.recievingOwnerUUID = request.getRecievingOwnerUUID();
        this.requestingOwnerUUID = request.getRequestingOwnerUUID();
        this.status = request.getStatus();
    }

    public RequestEntity toRequestEntity()
    {
        return new RequestEntity(requestingOwnerUUID, recievingOwnerUUID, status);
    }


    public boolean validateFields()
    {
        return requestingOwnerUUID == null || requestingOwnerUUID.isEmpty() || recievingOwnerUUID == null
                || recievingOwnerUUID.isEmpty() || status == null ? false : true;
    }

}
