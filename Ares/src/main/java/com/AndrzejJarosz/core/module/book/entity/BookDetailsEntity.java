package com.AndrzejJarosz.core.module.book.entity;

import javax.persistence.*;

@Entity
@Table(name = "book_details")
public class BookDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String lang;
    private String publisher;

    public Long getId() {
        return id;
    }

    public BookDetailsEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookDetailsEntity setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getLang() {
        return lang;
    }

    public BookDetailsEntity setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public BookDetailsEntity setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }
}
