package com.example.library_db.service;

import com.example.library_db.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Book addBook(Book book);

    Page<Book> getAllBooks(Pageable pageable);

    Book getBookById(Long id);

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);
}
