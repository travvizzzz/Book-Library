package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.model.Category;

@Service
public interface BookService 
{
	 Book saveBook(Book book) ;
	 
	 Category saveCategory(Category category);
	 
	 List<Book> getBooksByCategory(Long categoryId);
	 
	 List<Book> getAllBooks() ;
	 
	 List<Category> getAllCategories();
	 
	 Category getCategoryById(Long categoryId) ;
}
