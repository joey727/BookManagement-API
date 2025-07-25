package com.main.bookmanagement.repository;

import com.main.bookmanagement.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

}
