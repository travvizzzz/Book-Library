package com.example.demo.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link BookService}.
 */
@Generated
public class BookService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static BookService apply(RegisteredBean registeredBean, BookService instance) {
    AutowiredFieldValueResolver.forRequiredField("bookRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
