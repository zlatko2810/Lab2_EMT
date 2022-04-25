package com.example.demo.spring_boot.controller;

import com.example.demo.spring_boot.model.Book;
import com.example.demo.spring_boot.model.dto.BookDto;
import com.example.demo.spring_boot.model.exceptions.BookAlreadyExistsException;
import com.example.demo.spring_boot.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/add")
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
    }

    @PutMapping("/edit/{id}")
    public void editBook(@PathVariable Long id,
                         @RequestBody BookDto bookDto) {
        bookService.editBook(id, bookDto);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }


}
