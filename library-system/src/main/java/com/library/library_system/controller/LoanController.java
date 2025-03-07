package com.library.library_system.controller;

import com.library.library_system.model.Loan;
import com.library.library_system.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.findAll();
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return loanService.findById(id);
    }

    @PostMapping
    public void addLoan(@RequestBody Loan loan) {
        loanService.save(loan);
    }

    @PutMapping("/{id}/return")
    public void returnLoan(@PathVariable Long id) {
        loanService.returnBook(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanService.delete(id);
    }
}
