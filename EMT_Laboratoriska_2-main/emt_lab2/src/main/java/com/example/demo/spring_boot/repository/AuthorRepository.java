package com.example.demo.spring_boot.repository;

import com.example.demo.spring_boot.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("delete from Author a where a.name = ?1")
    Optional<Author> deleteAuthorByName(String name);

}
