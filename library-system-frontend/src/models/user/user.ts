export class User 
{
    pubKey: string;
    userName: string;
    description: string; 
    id: number;

    constructor(pubKey: string, id: number, userName: string, description: string)
    {
        this.pubKey = pubKey;
        this.userName = userName;
        this.description = description
        this.id = id;
    }
}