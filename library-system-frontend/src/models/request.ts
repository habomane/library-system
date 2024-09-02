export class Request
{
    requestId: string;
    requestingUserId: string;
    receivingUserId: string;
    status: string;
    details: string;
    dateCreated: Date;

    constructor(requestId: string, requestingUserId: string, receivingUserId: string, 
        status: string, details: string, dateCreated: string
    )
    {
        this.requestId = requestId;
        this.requestingUserId = requestingUserId;
        this.receivingUserId = receivingUserId;
        this.status = status;
        this.details = details;
        this.dateCreated = new Date(dateCreated);
    }

}

export class RequestRequest
{
    requestingUserId: string;
    receivingUserId: string;
    status: string;
    details: string;

    constructor(requestingUserId: string, receivingUserId: string, 
        status: string, details: string
    )
    {
        this.requestingUserId = requestingUserId;
        this.receivingUserId = receivingUserId;
        this.status = status;
        this.details = details;
    }

}