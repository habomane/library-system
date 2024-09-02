export class User 
{
    privateKey: string;
    description: string; 
    userId: string;
    dateCreation: Date;
    displayName: string;

    constructor(privateKey: string, userId: string, displayName: string, description: string, dateCreation: string)
    {

        this.privateKey = privateKey;
        this.description = description
        this.userId = userId;
        this.dateCreation = new Date(dateCreation);
        this.displayName = displayName;
    }
}

export class UserRequest
{
    privateKey: string;

    constructor(privateKey: string)
    {
        this.privateKey = privateKey;
    }
}