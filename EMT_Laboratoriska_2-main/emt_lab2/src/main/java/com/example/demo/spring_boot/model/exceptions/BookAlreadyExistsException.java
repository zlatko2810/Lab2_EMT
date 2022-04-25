package com.example.demo.spring_boot.model.exceptions;

public class BookAlreadyExistsException extends RuntimeException{

    public BookAlreadyExistsException(Long id) {
        super(String.format("Book with id: %d already exists.", id));
    }

}
