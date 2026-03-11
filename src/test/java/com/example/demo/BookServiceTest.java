package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.impl.BookServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testGetAllBooks() {

        Book book = new Book();
        List<Book> books = Arrays.asList(book);

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();

        System.out.println(result.size());
    }
    
    @Test
    void testGetBooksByCategory() {

        Long categoryId = 1L;

        Book book = new Book();
        book.setName("The guys of Rangoon");

        List<Book> books = Arrays.asList(book);

        when(bookRepository.findByCategoryId(categoryId)).thenReturn(books);

        List<Book> result = bookService.getBooksByCategory(categoryId);

        assertEquals(1, result.size());
    }
}
