package com.example.demo.repository;

import com.example.demo.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link BookRepository}.
 */
@Generated
public class BookRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public BookRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link BookRepository#getBookByIsbn(java.lang.String)}.
   */
  public Book getBookByIsbn(String isbn) {
    String queryString = "SELECT b FROM Book b WHERE b.isbn = :isbn";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("isbn", isbn);

    return (Book) convertOne(query.getSingleResultOrNull(), false, Book.class);
  }
}
