package com.example.library.controller;

import com.example.library.exception.BookNotFoundException;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * Ez az osztály a Spring Security beállításait konfigurálja.
 * A biztonsági szabályokat és a hitelesítési és hitelesítési beállításokat itt határozzuk meg.
 */

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    // további végpontok, mint például a könyv létrehozása, frissítése és törlése
    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
        return bookService.save(book);
    }

    // Könyvek listázása
    @GetMapping
    public List<Book> getAllBooks() {

        return bookService.findAll();
    }

    // Új könyv létrehozása
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {

        return bookService.save(book);
    }

    // Könyv adatainak lekérése
    /**
     * Ez az osztály a Spring Security beállításait konfigurálja.
     * annotációval jelöljük, hogy ezt az osztályt
     * használjuk a biztonsági konfigurációhoz.
     */

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return (Book) bookService.findById(id)
                .orElseThrow(() -> new BookNotFoundException(

                        "A könyv nem található az adott ID-val: " + id));
    }

    // Könyv adatainak frissítése
    /**
     * Ez az osztály a Spring Security beállításait konfigurálja.
     * annotációval jelöljük, hogy ezt az osztályt
     * használjuk a biztonsági konfigurációhoz.
     */

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return (Book) bookService.update(id, updatedBook)
                .orElseThrow(() -> new BookNotFoundException(
                        "A könyv nem található az adott ID-val: " + id));
    }

    // Könyv törlése
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}
