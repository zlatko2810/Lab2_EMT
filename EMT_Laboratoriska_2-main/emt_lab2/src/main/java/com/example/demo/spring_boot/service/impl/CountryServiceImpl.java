package com.example.demo.spring_boot.service.impl;

import com.example.demo.spring_boot.model.Country;
import com.example.demo.spring_boot.model.dto.CountryDto;
import com.example.demo.spring_boot.repository.CountryRepository;
import com.example.demo.spring_boot.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> addCountry(CountryDto countryDto) {

        Country country = new Country(countryDto.getName(), countryDto.getContinent());
        this.countryRepository.save(country);
        return Optional.of(country);

    }
}
