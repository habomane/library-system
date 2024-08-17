package com.library.books.entities;

public class Book {

    private String name;
    private String author;
    private String year;
    private double price;
    private int pageLength;
    private int currentPageNumber;
    private boolean isHardCover;

    Book(String name, String author, String year, double price, int pageLength,
         Integer currentPageNumber, boolean isHardCover)
    {
        this.name = name;
        this.author = author;
        this.year = year;
        this.price = price;
        this.pageLength = pageLength;
        this.currentPageNumber = currentPageNumber;
        this.isHardCover = isHardCover;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public int getPageLength()
    {
        return pageLength;
    }

    public void setPageLength(Integer pageLength)
    {
        this.pageLength = pageLength;
    }

    public int getCurrentPageNumber()
    {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(Integer pageNumber)
    {
        this.currentPageNumber = pageNumber;
    }

    public boolean getIsHardCover()
    {
        return isHardCover;
    }

    public void setIsHardCover(boolean isHardCover)
    {
        this.isHardCover = isHardCover;
    }




}
