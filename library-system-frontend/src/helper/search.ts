import { Book } from "../models";

export function queryBooks(query: string, items: Book[])
{
    const matchedNames = items.filter(book => book.title.toLowerCase().includes(query.toLowerCase()) || query.toLowerCase().includes(book.title.toLowerCase()));
    const matchedAuthors = items.filter(book => book.author.toLowerCase().includes(query.toLowerCase()) || query.toLowerCase().includes(book.author.toLowerCase()));
    const matchedGenres = items.filter(book => book.genre.toLowerCase().includes(query.toLowerCase()) || query.toLowerCase().includes(book.genre.toLowerCase()));

    return matchedNames.concat(matchedAuthors).concat(matchedGenres)

}

export function findBook(id: number, items: Book[])
{
    return items.find(book => book.id === id);
}