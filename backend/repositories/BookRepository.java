package com.example.bookStore.repositories;

import com.example.bookStore.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
