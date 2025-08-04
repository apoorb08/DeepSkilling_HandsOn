package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class Main {
    public static void main(String[] args) {
        // 1. Spring reads the XML and creates both beans.
        // 2. It then injects the bookRepository into the bookService.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 3. We ask Spring for the fully configured bookService bean.
        BookService bookService = (BookService) context.getBean("bookService");

        // 4. We call a method on it.
        bookService.addBook();
    }
}
