import { Book, BookRequest, BookRequestPut } from "../models";

const URL = import.meta.env.VITE_LIBRARY_SYSTEM_URL;

export async function getAllBooks()
{
    const response = await fetch(`${URL}/book/`);
    if(response.status !== 200) { return null; }

    const data = await response.json();
    
    return data.map((item) => {
        return new Book(item["bookId"], item["title"], item["author"],
            item["genre"], item["image"], item["available"], item["zipcode"],
            item["description"], item["ownerUserId"], item["dateCreated"]
        );
    })

}

export async function getAllBooksUser(userId: string)
{
    const response = await fetch(`${URL}/book/?userId=${userId}`);
    if(response.status !== 200) { return null; }

    const data = await response.json();
    
    return data.map((item) => {
        return new Book(item["bookId"], item["title"], item["author"],
            item["genre"], item["image"], item["available"], item["zipcode"],
            item["description"], item["ownerUserId"], item["dateCreated"]
        );
    })

}

export async function getBook(bookId: string)
{
    // get user here too
    const response = await fetch(`${URL}/book/${bookId}`);
    if(response.status !== 200) { return null; }

    const item = await response.json();
    return new Book(item["bookId"], item["title"], item["author"],
        item["genre"], item["image"], item["available"], item["zipcode"],
        item["description"], item["ownerUserId"], item["dateCreated"]
    );

}

export async function createBook(request: BookRequest)
{
    const options = {
        method: "POST",
        headers: {
          "Accept": "*/*",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(request),
      };
    
      const response = await fetch(`${URL}/book/create`, options);
      if(response.status !== 200) { return null; }

      const data  = await response.json();
      return new Book(data["bookId"], data["title"], data["author"],
        data["genre"], data["image"], data["available"], data["zipcode"],
        data["description"], data["ownerUserId"], data["dateCreated"]
    );
      
}

export async function deleteBook(bookId: string)
{
    const options = {
        method: "DELETE",
        headers: {
          "Accept": "*/*",
          "Content-Type": "application/json"
        }
      };
    
      const response = await fetch(`${URL}/book/delete/${bookId}`, options);
      if(response.status !== 202) { return null; }

      const data  = await response.json();
      return data;
      
}

export async function updateBook(book: BookRequestPut)
{
    console.log(JSON.stringify(book));
    const options = {
        method: "PUT",
        headers: {
          "Accept": "*/*",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(book)
      };
    
      const response = await fetch(`${URL}/book/update`, options);
      if(response.status !== 201) { return null; }

      const data  = await response.json();
      return data;
      
}