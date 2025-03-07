package com.library.library_system.model;

import java.util.Date;

public class Loan {
    private Long id;
    private Long bookId;
    private Long studentId;
    private Date loanDate;
    private Date returnDate;

    // Constructor vacío (necesario para MyBatis)
    public Loan() {}

    // Constructor con parámetros
    public Loan(Long id, Long bookId, Long studentId, Date loanDate, Date returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
