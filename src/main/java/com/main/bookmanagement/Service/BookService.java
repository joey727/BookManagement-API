package com.main.bookmanagement.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.bookmanagement.model.Book;
import com.main.bookmanagement.model.Borrower;
import com.main.bookmanagement.repository.BookRepository;
import com.main.bookmanagement.repository.BorrowerRepository;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository = null;

    @Autowired
    private final BorrowerRepository borrowerRepository = null;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book borrowBook(Long id, Borrower borrower) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.isAvailable()) {
            book.setAvailable(false);
            borrower = borrowerRepository.save(borrower);
            book.setBorrower(borrower);
            book.setDueDate(LocalDate.now().plusWeeks(2));
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book is not available for borrowing");
        }
    }

    public Book returnBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if (!book.isAvailable()) {
            book.setAvailable(true);
            book.setBorrower(null);
            book.setDueDate(null);
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book is already available");
        }
    }
}
