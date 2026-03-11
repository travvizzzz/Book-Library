package com.example.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link BookContoller}.
 */
@Generated
public class BookContoller__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static BookContoller apply(RegisteredBean registeredBean, BookContoller instance) {
    AutowiredFieldValueResolver.forRequiredField("bookService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
