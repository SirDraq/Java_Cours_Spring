package com.AndrzejJarosz.core.module.book;

import com.AndrzejJarosz.core.module.book.dto.BookDto;
import com.AndrzejJarosz.core.module.book.dto.BookForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookRestController {
	@Autowired
	private BookService bookService;

	@GetMapping("/api/book")
	public List<BookDto> getBooks() {
		return bookService.all();
	}

	@GetMapping(value = "/api/book/{id}")
	public BookDto getBook(@PathVariable Long id) {
		return bookService.one(id);
	}

	@PostMapping("/api/book")
	public BookDto newBooks(@RequestBody @Valid BookForm form) {
		return bookService.create(form);
	}

	@PutMapping("/api/book/{id}")
	public BookDto updateBooks(@PathVariable Long id, @RequestBody BookForm form) {
		return bookService.update(id,form);
	}

	@DeleteMapping("/api/book/{id}")
	public void deleteBooks(@PathVariable Long id) {
		bookService.delete(id);
	}

}
