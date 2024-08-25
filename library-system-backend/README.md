# Community Library REST API

This API allows users to make requests to create, retrieve, update, and delete books. 


##  Books

### Book Genre

When making requests to create or update the genre of a book, only several fields are permitted to be used (as reflected by the below examples). Each book can only have one one genre. The permitted fields include the following.

```
BookGenre = {
    FICTION,
    SCIENCE_FICTION,
    FANTASY,
    MYSTERY,
    THRILLER,
    ROMANCE,
    HORROR,
    HISTORICAL_FICTION,
    NON_FICTION,
    BIOGRAPHY,
    YOUNG_ADULT,
    DYSTOPIAN,
    CRIME,
    ADVENTURE,
    DRAMA
}
```


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
}

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

##  Book Requests

### Book Request Status

When making requests to create or update the status of a book request, only several fields are permitted to be used (as reflected by the below examples). The permitted fields include the following.

```
BookRequestStatus = {
    PENDING,
    CANCELED,
    APPROVED,
    REJECTED,
    NO_REQUEST,
    RESOLVED
}
```

### GET

<b>{api}/request</b>

This endpoint allows users to retrieve all the existing requests for books. Users can query for either the receiver and/or the requester by providing the values within the uri. A successful request will return a HTTP status of <strong>200.</strong>


```
// EXAMPLE RESPONSE
[
    {
        "requestId": "66cb2ec46fab8a2ccc770aa3",
        "requestingUUID": "Example Requester",
        "receivingUUID": "Example Reciever",
        "status": "APPROVED"
    },
    {
        "requestId": "66cb2eff6fab8a2ccc770aa4",
        "requestingUUID": "Example Requester 1",
        "receivingUUID": "Example Reciever 1",
        "status": "PENDING"
    }
]

```

<b>{api}/request/{id}</b>

This endpoint allows users to retrieve the request associated with the ID provided within the path parameter. A successful request will have a status of <strong>200.</strong>

```
// EXAMPLE RESPONSE 

{
 "requestId": "66cb2eff6fab8a2ccc770aa4",
 "requestingUUID": "Example Requester 1",
 "receivingUUID": "Example Reciever 1",
 "status": "PENDING"
}

```

### POST

<b>{api}/request/create</b>

This endpoint allows users to create a new request. The body of the requests follows the below schema:


```
// REQUEST BODY

{
 "requestingUUID": "",
 "receivingUUID": "",
 "status": ""
}
```

This endpoint will return the newly created request with the subsequent ID value. The ID value will be a hex string and can be supplied within the GET request endpoint. A successful request will have a status of <strong>201.</strong>

```
// RESPONSE

{
 "requestId": "66cb2eff6fab8a2ccc770aa4",
 "requestingUUID": "Example Requester 1",
 "receivingUUID": "Example Reciever 1",
 "status": "PENDING"
}
```

<b>{api}/book/create/many</b>

This endpoint allows users to create several request entities at once. The body of the requests must be provided within an array and follows the below schema:

```
// EXAMPLE REQUEST
[
{
 "requestingUUID": "",
 "receivingUUID": "",
 "status": ""
}, 
{..}
]

```

The users will be returned the created entities with their subsequent request id values. A successful request will have a status of <strong>201.</strong>

<b>{api}/request/update/</b>

This endpoint allows users to update a request entity by supplying the request body with the following schema. If an entity id is matched, the entire body will be updated. A successful request will have a status of <strong>201</strong> and the modified entity will be returned within the response.

```
// EXAMPLE REQUEST

{
 "requestId": "",
 "requestingUUID": "",
 "receivingUUID": "",
 "status": ""
}

```


<b>{api}/request/update/many</b>

This endpoint allows users to update several request entities by supplying the request body with the following schema. If an entity id is matched, the entire body will be updated. A successful request will have a status of <strong>201</strong> and the modified entity will be returned within the response. If any ids do not match the entities supplied, those items will not be provided within the response.


```
// EXAMPLE REQUEST

[
{
 "requestId": "",
 "requestingUUID": "",
 "receivingUUID": "",
 "status": ""
},
{..}
]

```


<b>{api}/request/delete/{url}</b>

This endpoint allows users to delete a request entity. The request id will need to be supplied as a path parameter. If an entity id is matched, the entity will be deleted. A successful request will have a status of <strong>202</strong>.


<b>{api}/request/delete/many</b>

This endpoint allows users to delete several request entities at once. The request id will not be supplied as a path parameter. Instead, the id values should be provided within the request parameter within an array. Only entities that match existing items will be deleted. A successful request will have a status of <strong>202</strong>.

```
// REQUEST EXAMPLE

["66c8b591b54f4e47f8f41f4e", "66c8cfb2ce9c2831646f5ae0"]

```

