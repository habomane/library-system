import { BookFavoriteRequest, BookFavorite } from "../models";

const URL = import.meta.env.VITE_LIBRARY_SYSTEM_URL;

export async function getFavorite(userId: string, bookId: string)
{
    if(bookId === undefined || bookId === "" || bookId === null) {return; }
    
    const response = await fetch(`${URL}/favorite/?userId=${userId}&bookId=${bookId}`);
    if(response.status !== 200) { return null; }

    const data = await response.json();
    
    return data.map((item: { [x: string]: string; }) => {
        return new BookFavorite(item["bookFavoriteId"], item["userId"], item["bookId"]);
    })
}

export async function getFavoriteByUser(userId: string)
{
    const response = await fetch(`${URL}/favorite/?userId=${userId}`);
    if(response.status !== 200) { return null; }

    const data = await response.json();

    return data.map((item: { [x: string]: string; }) => {
        return new BookFavorite(item["bookFavoriteId"], item["userId"], item["bookId"]);
    })
}

export async function createFavorite(favorite: BookFavoriteRequest)
{
    const options = {
        method: "POST",
        headers: {
          "Accept": "*/*",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(favorite),
      };
    
    const response = await fetch(`${URL}/favorite/create`, options);
    if(response.status !== 201) { return null; }

    const data = await response.json();

    return new BookFavorite(data["bookFavoriteId"], data["userId"], data["bookId"]);
    
}

export async function deleteFavorite(bookFavoriteId: string)
{
    const options = {
        method: "DELETE",
        headers: {
          "Accept": "*/*",
          "Content-Type": "application/json"
        }
      };
    
      const response = await fetch(`${URL}/favorite/delete/${bookFavoriteId}`, options);
      if(response.status !== 202) { return null; }

      const data  = await response.json();
      return data;
}