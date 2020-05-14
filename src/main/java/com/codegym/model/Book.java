package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private String decent;

    public Book() {
    }

    public Book(Long id, String name, String author, String decent) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.decent = decent;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDecent() {
        return decent;
    }

    public void setDecent(String decent) {
        decent = decent;
    }
}
