export class BookFavorite
{
    userId: string;
    bookId: string;
    bookFavoriteId: string;

    constructor(bookFavoriteId: string, userId: string, bookId: string)
    {
        this.bookFavoriteId = bookFavoriteId;
        this.userId = userId;
        this.bookId = bookId;
    }
}


export class BookFavoriteRequest
{
    userId: string;
    bookId: string;

    constructor(userId: string, bookId: string)
    {
        this.userId = userId;
        this.bookId = bookId;
    }
}

