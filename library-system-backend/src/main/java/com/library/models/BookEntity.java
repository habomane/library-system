package com.library.models;

import org.bson.types.ObjectId;
import com.library.types.BookGenre;
public class BookEntity {

    private ObjectId id = new ObjectId();
    private String title;
    private String author;
    private BookGenre genre;
    private String image;
    private String zipcode;
    private String description;
    private boolean available ;

    public BookEntity(String title, String author, BookGenre genre, String image, String zipcode,
         String description, boolean available)
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.image = image;
        this.zipcode = zipcode;
        this.description = description;
        this.available = available;
    }

    public ObjectId getId() { return id;}

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public BookGenre getGenre()
    {
        return genre;
    }

    public void setGenre(BookGenre genre)
    {
        this.genre = genre;
    }

    public String getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean getAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }


}
