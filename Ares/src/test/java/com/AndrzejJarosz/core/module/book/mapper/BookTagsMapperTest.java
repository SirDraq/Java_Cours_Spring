package com.AndrzejJarosz.core.module.book.mapper;

import com.AndrzejJarosz.core.module.book.entity.BookTagEntity;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BookTagsMapperTest {

    @Test
    void shouldReturnDtoContainingOneTag(){
        //given
        BookTagEntity tag1 = new BookTagEntity().setValue("Tag1");
        //when
        Set<String> tags = BookTagsMapper.map(Set.of(tag1));
        //then
        assertThat(tags).containsExactly("Tag1");
    }

    @Test
    void shouldReturnDtoContainingTwoTag(){
        //given
        BookTagEntity tag1 = new BookTagEntity().setValue("Tag1");
        BookTagEntity tag2 = new BookTagEntity().setValue("Tag2");
        //when
        Set<String> tags = BookTagsMapper.map(Set.of(tag1,tag2));
        //then
        assertThat(tags).containsExactly("Tag1","Tag2");
    }

    @Test
    void shouldReturnEmptySetWhenAnEmptySetIsProvided(){
        //given

        //when
        Set<String> tags = BookTagsMapper.map(Set.of());
        //then
        assertThat(tags).isEmpty();
    }

    @Test
    void shouldReturnEmptyWhenNullIsProvided(){
        //given
        Set<BookTagEntity> tagsSet = null;
        //when
        Set<String> tags = BookTagsMapper.map(tagsSet);
        //then
        assertThat(tags).isEmpty();
    }

}