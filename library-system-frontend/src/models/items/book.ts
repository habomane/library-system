export class Book {
    
    title: string;
    author: string;
    image: string;
    available: boolean;
    zipcode: string; 
    description: string;
    ownerUserName: string;

    constructor(title: string, author: string, image: string,
        available: boolean, zipcode: string, description: string,
        ownerUsername: string
    )
    {
        this.title = title;
        this.author = author;
        this.image = image;
        this.available = available;
        this.zipcode = zipcode;
        this.description = description;
        this.ownerUserName = ownerUsername

    }


    getLocationDetails()
    {
        // Implement here
    }

}