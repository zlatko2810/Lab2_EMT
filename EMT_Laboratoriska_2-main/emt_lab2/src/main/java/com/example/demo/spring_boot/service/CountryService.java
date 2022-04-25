package com.example.demo.spring_boot.service;

import com.example.demo.spring_boot.model.Country;
import com.example.demo.spring_boot.model.dto.CountryDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> getCountries();

    Optional<Country> getCountryById(Long id);

    Optional<Country> addCountry(CountryDto countryDto);

}
