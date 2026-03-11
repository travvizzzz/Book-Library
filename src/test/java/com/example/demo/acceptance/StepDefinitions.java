package com.example.demo.acceptance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Book;
import com.example.demo.model.Category;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions 
{
	private String server = System.getProperty("book.api.url","http://localhost:8080");
	private RestTemplate restTemplate;
	
	private Category category;
	private Book book;
	private ResponseEntity<Category> categoryResponse;
	private ResponseEntity<Book> bookResponse;
	private ResponseEntity<Book[]> booksResponse;
	
	 @Given("I have a category named {string}")
	 public void i_have_a_category_named(String name) 
	 {
	    category = new Category();
	    category.setName(name);
	 }
	
	 @When("I add this category via API")
	 public void i_add_this_category_via_api() throws Exception
	 {
		 URI uri = new URI(server + "/categories/add");
		 categoryResponse = restTemplate.postForEntity(uri, category, Category.class);
		 category = categoryResponse.getBody();
	 }
	 
	 @Then("the category should be created successfully")
	 public void the_category_should_be_created_successfully()
	 {
		 assertEquals(HttpStatus.OK,categoryResponse.getStatusCode());
		 assertTrue(category.getId() != null);
	 }
	 
	 @Given("I have a book named {string} by author {string} with ISBN {string} in category {string}")
	 public void i_have_a_book_named_by_author_with_isbn_in_category(String name, String author, String isbn, String categoryName)
	 {
		 book = new Book();
		 book.setName(name);
		 book.setAuthor(author);
		 book.setIsbn(isbn);
		 book.setCategory(category);
	 }
	 
	 @When("I add this book via API")
	 public void i_add_this_book_via_api() throws Exception
	 {
		 URI uri = new URI (server +"/book/add");
		 bookResponse = restTemplate.postForEntity(uri, book, Book.class);
		 book = bookResponse.getBody();
	 }
	 
	 @Then("the book should be created successfully")
	 public void the_book_should_be_created_successfully()
	 {
		 assertEquals(HttpStatus.OK,bookResponse.getStatusCode());
		 assertTrue(book.getId() != null);
		 assertEquals(category.getId(),book.getCategory().getId());
	 }
	 
	 @When("I fetch books for category {string}")
	 public void i_fetch_books_for_category(String categoryName) throws Exception
	 {
		 URI uri = new URI (server + "/books?category=" + categoryName);
		 booksResponse = restTemplate.getForEntity(uri, Book[].class);
		 		 
	 }
	 

	  @Then("I should receive a list containing {string}")
	  public void i_should_receive_a_list_containing(String bookName)
	  {
		  Book[] books = booksResponse.getBody();
		  Boolean found = false;
		  
		  for(Book b : books)
		  {
			  if(b.getName().equals(bookName))
			  {
				  found = true;
			  }
		  }
		  
		  assertTrue(found);
	  }
			

}
