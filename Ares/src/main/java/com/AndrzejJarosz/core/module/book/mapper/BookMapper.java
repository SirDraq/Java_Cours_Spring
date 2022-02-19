package com.AndrzejJarosz.core.module.book.mapper;

import com.AndrzejJarosz.core.module.book.dto.BookDto;
import com.AndrzejJarosz.core.module.book.dto.BookForm;
import com.AndrzejJarosz.core.module.book.entity.BookDetailsEntity;
import com.AndrzejJarosz.core.module.book.entity.BookEntity;
import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static List<BookDto> map(List<BookEntity> books) {
        return books
                .stream()
                .map(bookEntity -> map(bookEntity))
                .collect(Collectors.toList());
    }

    public static BookDto map(BookEntity book) {
        return new BookDto(
                book.getAuthor(),
                book.getTitle(),
                BookDetailsMapper.map(book.getDetails()),
                BookTagsMapper.map(book.getTags())
        );
    }

    public static BookEntity map(BookForm form, BookDetailsEntity details) {
        return new BookEntity()
                .setTitle(form.getTitle())
                .setAuthor(form.getAuthor())
                .setDetails(details);
    }
}
