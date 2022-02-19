package com.AndrzejJarosz.core.module.book;

import com.AndrzejJarosz.core.module.book.dto.BookDto;
import com.AndrzejJarosz.core.module.book.dto.BookForm;
import com.AndrzejJarosz.core.module.book.entity.BookDetailsEntity;
import com.AndrzejJarosz.core.module.book.entity.BookEntity;
import com.AndrzejJarosz.core.module.book.mapper.BookDetailsMapper;
import com.AndrzejJarosz.core.module.book.mapper.BookMapper;
import com.AndrzejJarosz.core.module.book.mapper.BookTagsMapper;
import com.AndrzejJarosz.core.module.book.repository.BooksDetailsRepository;
import com.AndrzejJarosz.core.module.book.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BooksRepository repository;
    @Autowired
    private BooksDetailsRepository detailsRepository;

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

        BookDetailsEntity details = BookDetailsMapper.map(form);
        details = detailsRepository.saveAndFlush(details);

        BookEntity book = BookMapper.map(form, details);

        book.setTags(BookTagsMapper.map(book, form.getTags()));

        return BookMapper.map(
                repository.saveAndFlush(book)
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
