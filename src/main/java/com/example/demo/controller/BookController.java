package com.example.demo.controller;

import com.example.demo.dto.request.BookRequestDto;
import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.BookResponseDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class BookController 
{

   @Autowired
   private BookService bookService;

    // ----------------- Category Endpoints -----------------

    @PostMapping("/categories")
    public CategoryResponseDto addCategory(@RequestBody CategoryRequestDto dto) 
    {
        Category category = Category.builder()
                .name(dto.getName())
                .build();
        Category saved = bookService.saveCategory(category);
        return convertCategoryToDto(saved);
    }

    @GetMapping("/categories")
    public List<CategoryResponseDto> getCategories()
    {
        return bookService.getAllCategories().stream()
                .map(this::convertCategoryToDto)
                .collect(Collectors.toList());
    }

    // ----------------- Book Endpoints -----------------

    @PostMapping("/books")
    public BookResponseDto addBook(@RequestBody BookRequestDto dto) 
    {
        Category category = bookService.getCategoryById(dto.getCategoryId());
        Book book = Book.builder()
                .name(dto.getName())
                .author(dto.getAuthor())
                .isbn(dto.getIsbn())
                .category(category)
                .build();
        Book saved = bookService.saveBook(book);
        return convertBookToDto(saved);
    }

    @GetMapping("/books")
    public List<BookResponseDto> getBooks() 
    {
        return bookService.getAllBooks().stream()
                .map(this::convertBookToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/books/category/{categoryId}")
    public List<BookResponseDto> getBooksByCategory(@PathVariable Long categoryId) 
    {
        return bookService.getBooksByCategory(categoryId).stream()
                .map(this::convertBookToDto)
                .collect(Collectors.toList());
    }

    // ----------------- DTO Conversion -----------------

    private BookResponseDto convertBookToDto(Book book) 
    {
        return BookResponseDto.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .categoryId(book.getCategory() != null ? book.getCategory().getId() : null)
                .categoryName(book.getCategory() != null ? book.getCategory().getName() : null)
                .build();
    }

    private CategoryResponseDto convertCategoryToDto(Category category) 
    {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}