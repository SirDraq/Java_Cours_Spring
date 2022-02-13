package com.AndrzejJarosz.core.module.book;

import com.AndrzejJarosz.core.module.book.dto.BookDto;
import com.AndrzejJarosz.core.module.book.dto.BookForm;
import com.AndrzejJarosz.core.module.book.entity.BookEntity;
import com.AndrzejJarosz.core.module.book.mapper.BookMapper;
import com.AndrzejJarosz.core.module.book.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BooksRepository repository;

    public List<BookDto> all() {
        return BookMapper.map(
                repository.findAll()
        );
    }

    public BookDto one(Long id) {
        return repository.findById(id)
                .map(BookMapper::map)
                .get();
    }

    public BookDto create(BookForm form) {
        BookEntity entity = new BookEntity()
                .setAuthor(form.getAuthor())
                .setTitle(form.getTitle());
        return BookMapper.map(
                repository.saveAndFlush(entity)
        );
    }

    public BookDto update(Long id, BookForm form){
        BookEntity fromDb = repository.getById(id)
                .setAuthor(form.getAuthor())
                .setTitle(form.getTitle());
        return BookMapper.map(
                repository.saveAndFlush(fromDb)
        );
    }

    public void delete(Long id) {
        repository.delete(
                repository.getById(id)
        );
    }
}
