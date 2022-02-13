package com.AndrzejJarosz.module.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {

	@Autowired
	private BooksRepository booksRepository;

	@GetMapping("/api/book")
	public List<BookEntity> getBooks() {
		return booksRepository.findAll();
	}

	@GetMapping(value = "/api/book/{id}")
	public BookDto getBook(@PathVariable Long id) {
		BookEntity book = booksRepository.findById(id).get();
		return new BookDto(
				book.getAuthor(),
				book.getTitle()
		);
	}

	@PostMapping("/api/book")
	public BookEntity newBooks(@RequestBody BookForm form) {
		BookEntity entity = new BookEntity()
				.setAuthor(form.getAuthor())
				.setTitle(form.getTitle());
		return booksRepository.saveAndFlush(entity);
	}

	@PutMapping("/api/book/{id}")
	public BookEntity updateBooks(@PathVariable Long id, @RequestBody BookForm form) {
		BookEntity bookFromDb = booksRepository.findById(id).get();
		bookFromDb.setTitle(form.getTitle());
		bookFromDb.setAuthor(form.getAuthor());
		booksRepository.saveAndFlush(bookFromDb);
		return bookFromDb;
	}

	@DeleteMapping("/api/book/{id}")
	public void deleteBooks(@PathVariable Long id) {
		booksRepository.deleteById(id);
	}

}
