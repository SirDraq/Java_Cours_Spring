package com.AndrzejJarosz.module.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookRestController{

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/api/book/")
    public List<BookEntity> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/api/book/{id}")
    public BookEntity getBook(@PathVariable Long id){
        Optional<BookEntity> byId = bookRepository.findById(id);
        return byId.orElse(new BookEntity());
    }

    @PostMapping("/api/book/")
    public BookEntity newBook(@RequestBody BookEntity book){
        return bookRepository.saveAndFlush(book);
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
    }

    @PutMapping("/api/book/{id}")
    public BookEntity updateBook(@PathVariable Long id, @RequestBody BookEntity book){
        return bookRepository.saveAndFlush(book.setId(id));
    }

    @PutMapping("/api/book/{id}/safe")
    public BookEntity updateSafeBook(@PathVariable Long id, @RequestBody BookEntity form){
        BookEntity bookDB = bookRepository.getById(id);

        if(form.getAuthor() != null){
            bookDB.setAuthor(form.getAuthor());
        }if (form.getTitle() != null){
            bookDB.setTitle(form.getTitle());
        }

        return bookRepository.saveAndFlush(bookDB);
    }
}
