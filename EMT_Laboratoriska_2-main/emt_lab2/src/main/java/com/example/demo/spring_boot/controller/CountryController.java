package com.example.demo.spring_boot.controller;

import com.example.demo.spring_boot.model.Book;
import com.example.demo.spring_boot.model.Country;
import com.example.demo.spring_boot.model.dto.BookDto;
import com.example.demo.spring_boot.model.dto.CountryDto;
import com.example.demo.spring_boot.service.BookService;
import com.example.demo.spring_boot.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll() {
        return countryService.getCountries();
    }

    @GetMapping("/{id}")
    public Optional<Country> findById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody CountryDto countryDto) {

        return this.countryService.addCountry(countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

}
