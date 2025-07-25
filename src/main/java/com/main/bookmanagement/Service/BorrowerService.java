package com.main.bookmanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.bookmanagement.model.Book;
import com.main.bookmanagement.model.Borrower;
import com.main.bookmanagement.repository.BorrowerRepository;

@Service
public class BorrowerService {

    @Autowired
    private final BorrowerRepository borrowerRepository = null;

    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public Borrower addBorrower(Book book) {
        Borrower borrower = book.getBorrower();
        if (borrower == null) {
            throw new RuntimeException("Book is not borrowed by any borrower");
        }
        return borrowerRepository.save(borrower);
    }

    public Borrower getBorrowerById(Long id) {
        return borrowerRepository.findById(id).orElseThrow(() -> new RuntimeException("Borrower not found"));
    }

    public List<Book> getBorrowedBooks(Long borrowerId) {
        Borrower borrower = borrowerRepository.findById(borrowerId)
                .orElseThrow(() -> new RuntimeException("Borrower not found"));
        return borrower.getBorrowedBooks();
    }
}
