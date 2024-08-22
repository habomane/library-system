# Library System REST API

This API allows users to make requests to create, retrieve, update, and delete books. This API also allows users to create, retrieve, update, and delete requests.


##  Books
 
### GET

<b>{api}/book</b>
This endpoint allows users to retrieve all the existing books.

<b>{api}/book/{id}</b>
This endpoint allows users to retrieve the book associated with the ID provided within the path parameter.


### POST

<b>{api}/book/create</b>
This endpoint allows users to create a new books. The body of the requests follows the below schema:


```
{
"title": "A Brave New World",
"author": "Aldous Huxley",
"genre": "SCIENCE_FICTION",
"zipcode": "11098", 
"description": "Brave New World is a dystopian novel by English author Aldous Huxley, written in 1931 and published in 1932.",
"available": true
}
```


