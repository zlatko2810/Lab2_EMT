package com.example.demo.spring_boot.service.impl;

import com.example.demo.spring_boot.model.Author;
import com.example.demo.spring_boot.model.Book;
import com.example.demo.spring_boot.model.dto.BookDto;
import com.example.demo.spring_boot.model.exceptions.AuthorNotFoundException;
import com.example.demo.spring_boot.model.exceptions.BookCopiesNotAvailable;
import com.example.demo.spring_boot.model.exceptions.BookNotFoundException;
import com.example.demo.spring_boot.repository.AuthorRepository;
import com.example.demo.spring_boot.repository.BookRepository;
import com.example.demo.spring_boot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> addBook(BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    @Transactional
    public Optional<Book> editBook(Long id, BookDto bookDto) {

        Book bookById = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        Author author = authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        bookById.setName(bookDto.getName());
        bookById.setCategory(bookDto.getCategory());
        bookById.setAuthor(author);
        bookById.setAvailableCopies(bookDto.getAvailableCopies());

        bookRepository.save(bookById);
        return Optional.of(bookById);
    }

    @Override
    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }
}
