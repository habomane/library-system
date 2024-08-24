# Community Library REST API

This API allows users to make requests to create, retrieve, update, and delete books. 


##  Books
 
### GET

<b>{api}/book</b>

This endpoint allows users to retrieve all the existing books. A successful request will have a status of <strong>200.</strong>

```
// EXAMPLE RESPONSE
[
{
"bookId": "66c8b591b54f4e47f8f41f4e",
"title": "A Brave New World",
"author": "Aldous Huxley",
"genre": "SCIENCE_FICTION",
"zipcode": "11098", 
"description": "Brave New World is a dystopian novel by English author Aldous Huxley, written in 1931 and published in 1932.",
"available": true
}, 
{
"bookId": "66c8b591b54f4e47f8f41f4e",
"title": "A Brave New World Version 2",
"author": "Aldous Huxley",
"genre": "SCIENCE_FICTION",
"zipcode": "11098", 
"description": "Brave New World is a dystopian novel by English author Aldous Huxley, written in 1931 and published in 1932.",
"available": true
}
]

```

<b>{api}/book/{id}</b>

This endpoint allows users to retrieve the book associated with the ID provided within the path parameter. A successful request will have a status of <strong>200.</strong>

```
// EXAMPLE RESPONSE 

{
"bookId": "66c8b591b54f4e47f8f41f4e",
"title": "A Brave New World",
"author": "Aldous Huxley",
"genre": "SCIENCE_FICTION",
"zipcode": "11098", 
"description": "Brave New World is a dystopian novel by English author Aldous Huxley, written in 1931 and published in 1932.",
"available": true
},

```

### POST

<b>{api}/book/create</b>

This endpoint allows users to create a new books. The body of the requests follows the below schema:


```
// REQUEST BODY

{
"title": "A Brave New World",
"author": "Aldous Huxley",
"genre": "SCIENCE_FICTION",
"zipcode": "11098", 
"description": "Brave New World is a dystopian novel by English author Aldous Huxley, written in 1931 and published in 1932.",
"available": true
}
```

This endpoint will return the newly created book with the subsequent ID value. The ID value will be a hext string and can be supplied within the GET book endpoint. A successful request will have a status of <strong>201.</strong>

```
// RESPONSE

{
"bookId": "66c8b591b54f4e47f8f41f4e",
"title": "A Brave New World",
"author": "Aldous Huxley",
"genre": "SCIENCE_FICTION",
"zipcode": "11098", 
"description": "Brave New World is a dystopian novel by English author Aldous Huxley, written in 1931 and published in 1932.",
"available": true
}
```

<b>{api}/book/create/many</b>

This endpoint allows users to create several book entities at once. The body of the requests must be provided within an array and follows the below schema:

```
// EXAMPLE REQUEST
[
{
"title": "",
"author": "",
"genre": "",
"zipcode": "", 
"description": "",
"available": false
}, 
{..}
]

```

The users will be returned the created entities with their subsequent book id values. A successful request will have a status of <strong>201.</strong>

<b>{api}/book/update/</b>

This endpoint allows users to update a book entity by supplying the request body with the following schema. If an entity id is matched, the entire body will be updated. A successful request will have a status of <strong>201</strong> and the modified entity will be returned within the response.

```
// EXAMPLE REQUEST

{
"bookId": "", 
"title": "",
"author": "",
"genre": "",
"zipcode": "", 
"description": "",
"available": false
}

```


<b>{api}/book/update/many</b>

This endpoint allows users to update several book entities by supplying the request body with the following schema. If an entity id is matched, the entire body will be updated. A successful request will have a status of <strong>201</strong> and the modified entity will be returned within the response. If any ids do not match the entities supplied, those items will not be provided within the response.


```
// EXAMPLE REQUEST

[
{
"bookId": "", 
"title": "",
"author": "",
"genre": "",
"zipcode": "", 
"description": "",
"available": false
},
{..}
]

```


<b>{api}/book/delete/{url}</b>

This endpoint allows users to delete a book entity. The book id will need to be supplied as a path parameter. If an entity id is matched, the entity will be deletd. A successful request will have a status of <strong>202</strong>.


<b>{api}/book/delete/many</b>

This endpoint allows users to delete several book entities at once. The book id will not be supplied as a path parameter. Instead, the id values should be provided within the request parameter within an array. Only entities that match existing items will be deleted. A successful request will have a status of <strong>202</strong>.

```
// REQUEST EXAMPLE

["66c8b591b54f4e47f8f41f4e", "66c8cfb2ce9c2831646f5ae0"]

```

