package com.AndrzejJarosz.module.book;

import com.AndrzejJarosz.module.book.dto.BookDto;
import com.AndrzejJarosz.module.book.dto.BookForm;
import com.AndrzejJarosz.module.book.entity.BookEntity;
import com.AndrzejJarosz.module.book.mapper.BookMapper;
import com.AndrzejJarosz.module.book.repository.BooksRepository;
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
	private BooksRepository booksRepository;

	@GetMapping("/api/book")
	public List<BookDto> getBooks() {
		return BookMapper.map(
				booksRepository.findAll()
		);
	}

	@GetMapping(value = "/api/book/{id}")
	public BookDto getBook(@PathVariable Long id) {
		return BookMapper.map(
				booksRepository.findById(id).get()
		);
	}

	@PostMapping("/api/book")
	public BookEntity newBooks(@RequestBody @Valid BookForm form) {
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
