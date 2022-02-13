package com.AndrzejJarosz.core.module.book.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String author;
	private String title;
	@OneToOne
	@JoinColumn(name = "details_id", referencedColumnName = "id")
	private BookDetailsEntity details;
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private Set<BookTagEntity> tags;

	public BookEntity() {
	}

	public Set<BookTagEntity> getTags() {
		return tags;
	}

	public BookEntity setTags(Set<BookTagEntity> tags) {
		this.tags = tags;
		return this;
	}

	public BookDetailsEntity getDetails() {
		return details;
	}

	public BookEntity setDetails(BookDetailsEntity details) {
		this.details = details;
		return this;
	}

	public Long getId() {
		return id;
	}

	public BookEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public BookEntity setAuthor(String author) {
		this.author = author;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public BookEntity setTitle(String title) {
		this.title = title;
		return this;
	}


}