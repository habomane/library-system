export class Book {
  title: string;
  author: string;
  image: string;
  available: boolean;
  zipcode: string;
  description: string;
  ownerUserName: string;
  genre: string;

  constructor(
    title: string,
    author: string,
    genre: string,
    image: string,
    available: boolean,
    zipcode: string,
    description: string,
    ownerUsername: string
  ) {
    this.title = title;
    this.author = author;
    this.image = image;
    this.available = available;
    this.zipcode = zipcode;
    this.description = description;
    this.ownerUserName = ownerUsername;
    this.genre = genre;
  }

  getLocationDetails() {
    // Implement here
  }
}
