package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Ez az osztály a Spring Security beállításait konfigurálja.
 * annotációval jelöljük, hogy ezt az osztályt
 * használjuk a biztonsági konfigurációhoz.
 */

@Repository
@SpringBootApplication
public interface BookRepository
        extends JpaRepository<Book, Long> {

}
