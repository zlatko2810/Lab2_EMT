package com.example.demo.spring_boot.service;

import com.example.demo.spring_boot.model.Author;
import com.example.demo.spring_boot.model.dto.AuthorDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> getAuthors();

    Optional<Author> getAuthorById(Long id);

    Optional<Author> deleteAuthorByName(String name);

    Optional<Author> addAuthor(AuthorDto authorDto);

}
