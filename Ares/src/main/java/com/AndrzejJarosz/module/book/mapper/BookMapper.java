package com.AndrzejJarosz.module.book.mapper;

import com.AndrzejJarosz.module.book.dto.BookDetailsDto;
import com.AndrzejJarosz.module.book.dto.BookDto;
import com.AndrzejJarosz.module.book.entity.BookEntity;
import com.AndrzejJarosz.module.book.entity.BookTagEntity;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {
    public static BookDto map(BookEntity book) {
        return new BookDto(
                book.getAuthor(),
                book.getTitle(),
                new BookDetailsDto(
                        book.getDetails().getIsbn(),
                        book.getDetails().getLang()
                ),
                book.getTags()
                        .stream()
                        .map(BookTagEntity::getValue)
                        .collect(Collectors.toSet())
        );
    }

    public static List<BookDto> map(List<BookEntity> books) {
        return books.stream()
                .map(BookMapper::map)
                .collect(Collectors.toList());
    }
}
