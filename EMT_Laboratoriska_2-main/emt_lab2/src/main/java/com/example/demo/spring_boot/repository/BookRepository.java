package com.example.demo.spring_boot.repository;

import com.example.demo.spring_boot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("delete from Book b where b.name = ?1")
    Optional<Book> deleteBookByName(String name);

}
