package com.example.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BookContoller}.
 */
@Generated
public class BookContoller__BeanDefinitions {
  /**
   * Get the bean definition for 'bookContoller'.
   */
  public static BeanDefinition getBookContollerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BookContoller.class);
    InstanceSupplier<BookContoller> instanceSupplier = InstanceSupplier.using(BookContoller::new);
    instanceSupplier = instanceSupplier.andThen(BookContoller__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
