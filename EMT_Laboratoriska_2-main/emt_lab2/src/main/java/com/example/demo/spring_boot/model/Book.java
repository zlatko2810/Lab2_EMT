package com.example.demo.spring_boot.model;

import com.example.demo.spring_boot.model.enumerations.BookCategory;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Column(name = "category_id")
    @Enumerated(EnumType.STRING)
    BookCategory category;

    @ManyToOne
    Author author;

    @Column(name = "available_copies")
    Integer availableCopies;

    public Book(){}

    public Book(String name, BookCategory category, Author author, Integer availableCopies){
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }


}
