package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Ez az osztály a Spring Security beállításait konfigurálja.
 * annotációval jelöljük, hogy ezt az osztályt
 * használjuk a biztonsági konfigurációhoz.
 */

@Service
public class BookService {
    private final BookRepository bookRepository;

    private Long id;
    private Book updatedBook;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public Book save(Book book) {
        return book;
    }

    public Optional<Object> findById(Long id) {
        this.id = id;
        return Optional.empty();
    }

    /**
     * Ez az osztály a Spring Security beállításait konfigurálja.
     * annotációval jelöljük, hogy ezt az osztályt
     * használjuk a biztonsági konfigurációhoz.
     */

    public Optional<Object> update(Long id, Book updatedBook) {
        this.id = id;
        this.updatedBook = updatedBook;
        return Optional.empty();
    }

    public void delete(Long id) {

        this.id = id;
    }

    /**
     * Ez az osztály a Spring Security beállításait konfigurálja.
     * annotációval jelöljük, hogy ezt az osztályt
     * használjuk a biztonsági konfigurációhoz.
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getUpdatedBook() {
        return updatedBook;
    }

    public void setUpdatedBook(Book updatedBook) {
        this.updatedBook = updatedBook;
    }
}
