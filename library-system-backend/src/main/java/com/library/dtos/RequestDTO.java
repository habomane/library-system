package com.library.dtos;

import com.library.types.*;
import com.library.models.*;

public class RequestDTO {
    public String requestId;
    public String requestingUUID;
    public String receivingUUID;
    public BookRequestStatus status;

    public RequestDTO() {}

    public RequestDTO(RequestEntity request)
    {
        this.requestId = request.getRequestId();
        this.receivingUUID = request.getreceivingUUID();
        this.requestingUUID = request.getrequestingUUID();
        this.status = request.getStatus();
    }

    public RequestEntity toRequestEntity()
    {
        return new RequestEntity(requestId, requestingUUID, receivingUUID, status);
    }

    public boolean validateFields()
    {
        return requestingUUID == null || requestingUUID.isEmpty() || receivingUUID == null
                || receivingUUID.isEmpty() || status == null ? false : true;
    }


}
