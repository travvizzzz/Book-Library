package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService 
{

	  @Autowired 
	  private BookRepository bookRepository;
	  
	  @Autowired
	  private CategoryRepository categoryRepository;

    @Override
    public Book saveBook(Book book)
    {
        return bookRepository.save(book);
    }

    @Override
    public Category saveCategory(Category category) 
    {
        return categoryRepository.save(category);
    }

    @Override
    public List<Book> getBooksByCategory(Long categoryId) 
    {
        return bookRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Book> getAllBooks() 
    {
        return bookRepository.findAll();
    }

    @Override
    public List<Category> getAllCategories() 
    {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) 
    {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));
    }
}