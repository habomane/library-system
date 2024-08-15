package com.library.books;

public class GraphicNovel extends Book {

    private String animator;
    GraphicNovel(String name, String author, String year, double price, int pageLength,
                 Integer currentPageNumber, boolean isHardCover, String animator)
    {
        super(name, author, year, price, pageLength, currentPageNumber, isHardCover);
        this.animator = animator;
    }


}
