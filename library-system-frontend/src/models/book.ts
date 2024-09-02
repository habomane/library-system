import * as helper from "../helper";
export class Book {
  bookId: string;
  title: string;
  author: string;
  image: string;
  available: boolean;
  zipcode: string;
  description: string;
  ownerUserId: string;
  genre: string;
  dateCreated: Date;

  constructor(
    bookId: string,
    title: string,
    author: string,
    genre: string,
    image: string,
    available: boolean,
    zipcode: string,
    description: string,
    ownerUserId: string,
    dateCreated: string
  ) {
    this.bookId = bookId;
    this.title = title;
    this.author = author;
    this.image = image;
    this.available = available;
    this.zipcode = zipcode;
    this.description = description;
    this.ownerUserId = ownerUserId;
    this.genre = helper.transformGenreString(genre) || "";
    this.dateCreated = new Date(dateCreated);
  }
}

export class BookRequest {
  title: string;
  author: string;
  image: string;
  available: boolean;
  zipcode: string;
  description: string;
  ownerUserId: string;
  genre: string;

  constructor(
    title: string,
    author: string,
    genre: string,
    image: string,
    available: boolean,
    zipcode: string,
    description: string,
    ownerUserId: string
  ) {
    this.title = title;
    this.author = author;
    this.image = image;
    this.available = available;
    this.zipcode = zipcode;
    this.description = description;
    this.ownerUserId = ownerUserId;
    this.genre = genre;
  }
}

export class BookRequestPut {
  bookId: string;
  title: string;
  author: string;
  image: string;
  available: boolean;
  zipcode: string;
  description: string;
  ownerUserId: string;
  genre: string;
  dateCreated: string;

  constructor(
    bookId: string,
    title: string,
    author: string,
    genre: string,
    image: string,
    available: boolean,
    zipcode: string,
    description: string,
    ownerUserId: string,
    dateCreated: string
  ) {
    this.bookId = bookId;
    this.title = title;
    this.author = author;
    this.image = image;
    this.available = available;
    this.zipcode = zipcode;
    this.description = description;
    this.ownerUserId = ownerUserId;
    this.genre = genre;
    this.dateCreated = dateCreated;
  }
}
