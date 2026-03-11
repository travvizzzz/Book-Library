package com.example.demo;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BookLibraryApplication}.
 */
@Generated
public class BookLibraryApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'bookLibraryApplication'.
   */
  public static BeanDefinition getBookLibraryApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BookLibraryApplication.class);
    beanDefinition.setInstanceSupplier(BookLibraryApplication::new);
    return beanDefinition;
  }
}
