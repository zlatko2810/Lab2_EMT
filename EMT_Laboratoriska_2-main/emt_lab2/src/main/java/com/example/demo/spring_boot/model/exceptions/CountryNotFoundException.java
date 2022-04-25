package com.example.demo.spring_boot.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException(Long id) {
        super(String.format("Country with id: %d does not exist.", id));
    }


}
