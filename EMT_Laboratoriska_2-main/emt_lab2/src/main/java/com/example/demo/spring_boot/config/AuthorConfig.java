package com.example.demo.spring_boot.config;

import com.example.demo.spring_boot.model.Author;
import com.example.demo.spring_boot.model.Country;
import com.example.demo.spring_boot.repository.AuthorRepository;
import com.example.demo.spring_boot.repository.CountryRepository;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AuthorConfig {

    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository authorRepository, CountryRepository countryRepository) {
        return args -> {

            Country country1 = new Country("Makedonija", "Evropa");
            Country country2 = new Country("Srbija", "Evropa");
            Country country3 = new Country("Hrvatska", "Evropa");
            Country country4 = new Country("Bosna i Hercegovina", "Evropa");
            Country country5 = new Country("Crna Gora", "Evropa");
            Country country6 = new Country("Slovenija", "Evropa");

            countryRepository.saveAll(
                    List.of(
                            country1,
                            country2,
                            country3,
                            country4,
                            country5,
                            country6
                    )
            );

            Author author1 = new Author("Petar", "Kostadinovski", country1);
            Author author2 = new Author("David", "Gakovski", country1);
            Author author3 = new Author("Luka", "Jovanovski", country1);
            Author author4 = new Author("Andrej", "Andric", country2);
            Author author5 = new Author("Pavel", "Pavlovic", country2);
            Author author6 = new Author("Milos", "Petric", country3);
            Author author7 = new Author("Vladimir", "Jovic", country3);
            Author author8 = new Author("Nikola", "Matic", country4);
            Author author9 = new Author("Zoran", "Blagoevic", country5);
            Author author10 = new Author("Novak", "Djokic", country6);

            authorRepository.saveAll(List.of(
               author1,
               author2,
               author3,
               author4,
               author5,
               author6,
               author7,
               author8,
               author9,
               author10
            )
            );
        };
    }

}
