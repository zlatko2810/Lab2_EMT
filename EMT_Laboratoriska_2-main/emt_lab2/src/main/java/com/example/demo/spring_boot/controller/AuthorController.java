package com.example.demo.spring_boot.controller;

import com.example.demo.spring_boot.model.Author;
import com.example.demo.spring_boot.model.Book;
import com.example.demo.spring_boot.model.dto.AuthorDto;
import com.example.demo.spring_boot.model.dto.BookDto;
import com.example.demo.spring_boot.service.AuthorService;
import com.example.demo.spring_boot.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll() {
        return authorService.getAuthors();
    }

    @GetMapping("/{id}")
    public Optional<Author> findById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/add")
    public void addAuthor(@RequestBody AuthorDto authorDto) {
        authorService.addAuthor(authorDto);
    }
}
