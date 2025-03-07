package com.library.library_system.service;

import com.library.library_system.model.Loan;
import com.library.library_system.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookService bookService;

    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    public Loan findById(Long id) {
        return loanRepository.findById(id);
    }

    public void save(Loan loan) {
        if (loan.getId() == null) {
            loan.setLoanDate(new Date()); // Fecha actual como fecha de préstamo
            loanRepository.insert(loan);
            bookService.decrementAvailable(loan.getBook().getId()); // Disminuye la cantidad disponible
        } else {
            loanRepository.update(loan);
        }
    }

    public void returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId);
        if (loan != null) {
            loan.setReturnDate(new Date()); // Fecha actual como fecha de devolución
            loanRepository.update(loan);
            bookService.incrementAvailable(loan.getBook().getId()); // Aumenta la cantidad disponible
        }
    }

    public void delete(Long id) {
        loanRepository.delete(id);
    }
}
