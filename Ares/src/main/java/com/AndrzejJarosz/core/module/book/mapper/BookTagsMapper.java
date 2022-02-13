package com.AndrzejJarosz.core.module.book.mapper;

import com.AndrzejJarosz.core.module.book.entity.BookEntity;
import com.AndrzejJarosz.core.module.book.entity.BookTagEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class BookTagsMapper {
    public static Set<String> map(Set<BookTagEntity> tags) {
        return tags.stream()
                .map(BookTagEntity::getValue)
                .collect(Collectors.toSet());
    }
}
