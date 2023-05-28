package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

public class BookServiceTest {
    private BookService bookService;
    private BookRepository bookRepository;

    @BeforeEach
    public void setup() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void findAllTest() {
        // Given
        Book book1 = new Book(1L, "Title", "Author", "ISBN");
        book1.setId(1L);
        book1.setName("Book 1");

        Book book2 = new Book(1L, "Title", "Author", "ISBN");
        book2.setId(2L);
        book2.setName("Book 2");

        given(bookRepository.findAll()).willReturn(Arrays.asList(book1, book2));

        // When
        List<Book> result = bookService.findAll();

        // Then
        assertEquals(2, result.size());
        assertEquals(book1, result.get(0));
        assertEquals(book2, result.get(1));
    }

    @Test
    public void saveTest() {
        // Given
        Book book = new Book(1L, "Title", "Author", "ISBN");
        book.setId(3L);
        book.setName("Book 3");

        // When
        Book result = bookService.save(book);

        // Then
        assertEquals(book, result);
    }
}
