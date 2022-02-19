package com.AndrzejJarosz.core.module.book.mapper;

import com.AndrzejJarosz.core.module.book.entity.BookEntity;
import com.AndrzejJarosz.core.module.book.entity.BookTagEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookTagsMapper {

    public static Set<String> map(Set<BookTagEntity> tags) {
        if (tags == null) {
            return Set.of();
        }
        return tags
                .stream()
                .map(tag -> tag.getValue())
                .collect(Collectors.toSet());
    }

    public static Set<BookTagEntity> map(BookEntity book, List<String> tags) {
        return tags.stream()
                .map(tagStr -> new BookTagEntity().setBook(book).setValue(tagStr))
                .collect(Collectors.toSet());
    }
}
