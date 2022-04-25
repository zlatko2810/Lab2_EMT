package com.example.demo.spring_boot.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(Long id) {
        super(String.format("Author with id: %d does not exist.", id));
    }


}
