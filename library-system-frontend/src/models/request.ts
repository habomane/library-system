export class Request
{
    requestId: string;
    requesterUserId: string;
    receivingUserId: string;
    status: string;
    details: string;
    dateCreated: Date;

    constructor(requestId: string, requesterUserId: string, receivingUserId: string, 
        status: string, details: string, dateCreated: string
    )
    {
        this.requestId = requestId;
        this.requesterUserId = requesterUserId;
        this.receivingUserId = receivingUserId;
        this.status = status;
        this.details = details;
        this.dateCreated = new Date(dateCreated);
    }

}

export class RequestRequest
{
    requesterUserId: string;
    receivingUserId: string;
    status: string;
    details: string;

    constructor(requesterUserId: string, receivingUserId: string, 
        status: string, details: string
    )
    {
        this.requesterUserId = requesterUserId;
        this.receivingUserId = receivingUserId;
        this.status = status;
        this.details = details;
    }

}