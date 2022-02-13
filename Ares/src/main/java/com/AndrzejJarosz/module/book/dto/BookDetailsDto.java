package com.AndrzejJarosz.module.book.dto;

public class BookDetailsDto {
    private final String isbn;
    private final String lang;

    public BookDetailsDto(String isbn, String lang) {
        this.isbn = isbn;
        this.lang = lang;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getLang() {
        return lang;
    }
}
