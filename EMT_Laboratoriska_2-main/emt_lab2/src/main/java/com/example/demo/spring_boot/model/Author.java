package com.example.demo.spring_boot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String surname;

    @ManyToOne
    Country country;

    public Author(){}

    public Author(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
