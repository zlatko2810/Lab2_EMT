package com.example.demo.spring_boot.model.dto;

import com.example.demo.spring_boot.model.Country;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class AuthorDto {

    String name;

    String surname;

    Long country;

}
