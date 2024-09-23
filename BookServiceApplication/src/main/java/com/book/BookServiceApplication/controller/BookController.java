package com.book.BookServiceApplication.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.BookServiceApplication.Entity.Book;

@RequestMapping("/api/books")
@RestController
public class BookController {

    @GetMapping
    public List<Book> getAllBooks() {
        return Arrays.asList(
                new Book(1l, "all about sujini", "Sujini", 500.50),
                new Book(2l, "Harry potter", "Bharath", 1000.50),
                new Book(3l, "Flying colours", "ram", 4500.50),
                new Book(4l, "about urself grow", "sankar", 450.50));
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return new Book(id, "some title", "xyz", 123.00);
    }

}
