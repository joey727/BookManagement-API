package com.main.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.main.bookmanagement.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
