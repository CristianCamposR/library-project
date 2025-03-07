package com.library.library_system.controller;

import com.library.library_system.model.Book;
import com.library.library_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/{id}") // GET /api/books/{id}
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping // POST /api/books
    public void addBook(@RequestBody Book book) {
        bookService.save(book);
    }

    @PutMapping("/{id}") // PUT /api/books/{id}
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id); // Asegura que el ID sea el correcto
        bookService.save(book);
    }

    @DeleteMapping("/{id}") // DELETE /api/books/{id}
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}
