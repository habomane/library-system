package com.library.dtos;

import com.library.models.RequestEntity;
import com.library.types.BookRequestStatus;

public class RequestRequestDTO {
    public String requestingUUID;
    public String receivingUUID;
    public BookRequestStatus status;

    public RequestRequestDTO() {}

    public RequestRequestDTO(RequestEntity request)
    {
        this.receivingUUID = request.getreceivingUUID();
        this.requestingUUID = request.getrequestingUUID();
        this.status = request.getStatus();
    }

    public RequestEntity toRequestEntity()
    {
        return new RequestEntity(requestingUUID, receivingUUID, status);
    }


    public boolean validateFields()
    {
        return requestingUUID == null || requestingUUID.isEmpty() || receivingUUID == null
                || receivingUUID.isEmpty() || status == null ? false : true;
    }

}
