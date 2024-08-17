package com.library.books.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GraphicNovel extends Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String animator;
    GraphicNovel(String name, String author, String year, double price, int pageLength,
                 Integer currentPageNumber, boolean isHardCover, String animator)
    {
        super(name, author, year, price, pageLength, currentPageNumber, isHardCover);
        this.animator = animator;
    }


}
