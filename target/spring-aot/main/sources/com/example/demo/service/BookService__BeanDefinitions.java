package com.example.demo.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BookService}.
 */
@Generated
public class BookService__BeanDefinitions {
  /**
   * Get the bean definition for 'bookService'.
   */
  public static BeanDefinition getBookServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BookService.class);
    InstanceSupplier<BookService> instanceSupplier = InstanceSupplier.using(BookService::new);
    instanceSupplier = instanceSupplier.andThen(BookService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
