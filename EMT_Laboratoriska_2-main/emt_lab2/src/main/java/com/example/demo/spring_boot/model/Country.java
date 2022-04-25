package com.example.demo.spring_boot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String continent;

    public Country(){}

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
