package com.main.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.bookmanagement.Service.BookService;
import com.main.bookmanagement.model.Book;
import com.main.bookmanagement.model.Borrower;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private final BookService bookService = null;

    @GetMapping("/list")
    public List<Book> listBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping("/{id}/borrow")
    public Book borrowBook(@PathVariable Long id, @RequestBody Borrower borrowerName) {
        return bookService.borrowBook(id, borrowerName);
    }

    @PostMapping("/{id}/return")
    public Book returnBook(@PathVariable Long id) {
        return bookService.returnBook(id);
    }
}
