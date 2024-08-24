package com.library.dtos;

import com.library.types.*;
import com.library.models.*;

public class RequestDTO {
    public String requestId;
    public String requestingOwnerUUID;
    public String recievingOwnerUUID;
    public BookRequestStatus status;

    public RequestDTO() {}

    public RequestDTO(RequestEntity request)
    {
        this.requestId = request.getRequestId();
        this.recievingOwnerUUID = request.getRecievingOwnerUUID();
        this.requestingOwnerUUID = request.getRequestingOwnerUUID();
        this.status = request.getStatus();
    }

    public RequestEntity toRequestEntity()
    {
        return new RequestEntity(requestId, requestingOwnerUUID, recievingOwnerUUID, status);
    }

    public boolean validateFields()
    {
        return requestingOwnerUUID == null || requestingOwnerUUID.isEmpty() || recievingOwnerUUID == null
                || recievingOwnerUUID.isEmpty() || status == null ? false : true;
    }


}
