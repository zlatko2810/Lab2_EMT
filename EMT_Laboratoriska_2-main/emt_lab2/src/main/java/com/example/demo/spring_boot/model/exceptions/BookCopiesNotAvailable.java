package com.example.demo.spring_boot.model.exceptions;

public class BookCopiesNotAvailable extends RuntimeException{

    public BookCopiesNotAvailable(Long id) {
        super(String.format("Copies of book with id %d, not available!", id));
    }

}
