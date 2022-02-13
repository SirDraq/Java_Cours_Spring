package com.AndrzejJarosz.core.module.book.mapper;

import com.AndrzejJarosz.core.module.book.dto.BookDetailsDto;
import com.AndrzejJarosz.core.module.book.entity.BookDetailsEntity;

public class BookDetailsMapper {
    public static BookDetailsDto map(BookDetailsEntity details){
        return new BookDetailsDto(
                details.getIsbn(),
                details.getLang()
        );
    }
}
