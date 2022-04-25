package com.example.demo.spring_boot.service.impl;

import com.example.demo.spring_boot.model.Author;
import com.example.demo.spring_boot.model.Country;
import com.example.demo.spring_boot.model.dto.AuthorDto;
import com.example.demo.spring_boot.model.exceptions.CountryNotFoundException;
import com.example.demo.spring_boot.repository.AuthorRepository;
import com.example.demo.spring_boot.repository.CountryRepository;
import com.example.demo.spring_boot.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository){
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> deleteAuthorByName(String name) {
        return authorRepository.deleteAuthorByName(name);
    }

    @Override
    public Optional<Author> addAuthor(AuthorDto authorDto) throws CountryNotFoundException {

        Country countryById = countryRepository.findById(authorDto.getCountry())
                .orElseThrow(() ->  new CountryNotFoundException(authorDto.getCountry()));
        Author author = new Author(authorDto.getName(), authorDto.getSurname(),countryById);
        authorRepository.save(author);
        return Optional.of(author);

    }
}
