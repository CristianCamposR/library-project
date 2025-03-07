package com.library.library_system.controller;

import com.library.library_system.model.Book;
import com.library.library_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}") // GET /api/books/{id}
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping // POST /api/books
    public ResponseEntity<Map<String, String>> addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}") // PUT /api/books/{id}
    public ResponseEntity<Map<String, String>> updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id); // Asegura que el ID sea el correcto
        return bookService.save(book);
    }

    @DeleteMapping("/{id}") // DELETE /api/books/{id}
    public ResponseEntity<Map<String, String>> deleteBook(@PathVariable Long id) {
        return bookService.delete(id);
    }
}