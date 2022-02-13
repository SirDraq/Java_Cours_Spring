package com.AndrzejJarosz.module.book;

public class BookDto  {
	private String author;
	private String title;

	public BookDto() {
	}

	public BookDto(String author, String title) {
		this.author = author;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}
}
