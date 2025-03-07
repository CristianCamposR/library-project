package com.library.library_system.model;

import java.util.Date;

public class Loan {
    private Long id;
    private  Book book;
    private Student student;
    private Date loanDate;
    private Date returnDate;

    // Constructor vacío (necesario para MyBatis)
    public Loan() {}

    // Constructor con parámetros

    public Loan(Long id, Book book, Student student, Date loanDate, Date returnDate) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
