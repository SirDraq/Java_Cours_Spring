package com.AndrzejJarosz.core.module.book.repository;

import com.AndrzejJarosz.core.module.book.entity.BookDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BooksDetailsRepository extends JpaRepository<BookDetailsEntity, Long>, JpaSpecificationExecutor<BookDetailsEntity> {
}
