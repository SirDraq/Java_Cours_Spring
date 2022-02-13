package com.AndrzejJarosz.module.book.dto;

import com.AndrzejJarosz.module.book.dto.BookDetailsDto;

import java.util.Set;

public class BookDto  {
	private final String author;
	private final String title;
	private BookDetailsDto detailsDto;
	private Set<String> tags;

	public BookDto(String author, String title, BookDetailsDto detailsDto) {
		this.author = author;
		this.title = title;
		this.detailsDto = detailsDto;
	}

	public BookDto(String author, String title, BookDetailsDto detailsDto, Set<String> tags) {
		this.author = author;
		this.title = title;
		this.detailsDto = detailsDto;
		this.tags = tags;
	}

	public Set<String> getTags() {
		return tags;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public BookDetailsDto getDetailsDto() {
		return detailsDto;
	}
}
