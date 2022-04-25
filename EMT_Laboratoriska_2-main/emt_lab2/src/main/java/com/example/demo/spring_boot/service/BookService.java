package com.example.demo.spring_boot.service;

import com.example.demo.spring_boot.model.Book;
import com.example.demo.spring_boot.model.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBooks();

    Optional<Book> getBookById(Long id);

    Optional<Book> addBook(BookDto bookDto);

    Optional<Book> editBook(Long id, BookDto bookDto);

    void deleteBook(Long id);
}
