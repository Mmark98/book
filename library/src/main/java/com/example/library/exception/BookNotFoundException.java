package com.example.library.exception;

/**
 * Ez az osztály a Spring Security beállításait konfigurálja.
 * annotációval jelöljük, hogy ezt az osztályt
 * használjuk a biztonsági konfigurációhoz.
 */

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String id) {
        super("Book not found with id " + id);
    }
}
