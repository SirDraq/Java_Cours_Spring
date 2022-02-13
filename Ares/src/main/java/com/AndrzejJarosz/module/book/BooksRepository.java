package com.AndrzejJarosz.module.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BooksRepository extends JpaRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> {
}