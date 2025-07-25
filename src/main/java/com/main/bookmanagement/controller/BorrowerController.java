package com.main.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.bookmanagement.Service.BorrowerService;
import com.main.bookmanagement.model.Borrower;

@RestController
@RequestMapping("/borrowers")
public class BorrowerController {
    @Autowired
    private final BorrowerService borrowerService = null;

    @GetMapping("/list")
    public List<Borrower> listBorrowers() {
        return borrowerService.getAllBorrowers();
    }

}
