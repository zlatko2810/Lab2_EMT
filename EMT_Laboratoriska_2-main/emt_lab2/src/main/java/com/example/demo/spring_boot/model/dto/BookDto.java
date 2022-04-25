package com.example.demo.spring_boot.model.dto;

import com.example.demo.spring_boot.model.Author;
import com.example.demo.spring_boot.model.enumerations.BookCategory;
import lombok.Data;

import javax.persistence.Column;

@Data
public class BookDto {

    private String name;

    private BookCategory category;

    private Long author;

    private Integer availableCopies;

}
