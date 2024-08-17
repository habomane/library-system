package com.library.books.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Novel extends Book {

    private PrintSize size;

    Novel(String name, String author, String year, double price, int pageLength,
          Integer currentPageNumber, boolean isHardCover, PrintSize size)
    {
        super(name, author, year, price, pageLength, currentPageNumber, isHardCover);
        this.size = size;
    }

    public PrintSize getSize()
    {
        return size;
    }

    public void setSize(PrintSize size)
    {
        this.size = size;
    }



}
