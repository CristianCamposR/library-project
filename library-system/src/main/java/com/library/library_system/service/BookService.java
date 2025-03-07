package com.library.library_system.service;

import com.library.library_system.model.Book;
import com.library.library_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    public ResponseEntity<Book> findById(Long id) {
        Book book = bookRepository.findById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(book);
    }

    public ResponseEntity<Map<String, String>> save(Book book) {
        Map<String, String> response = new HashMap<>();

        if (book == null) {
            response.put("message", "El libro no puede ser nulo.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            if (book.getId() == null) {
                bookRepository.insert(book);
                response.put("message", "Libro creado exitosamente.");
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                bookRepository.update(book);
                response.put("message", "Libro actualizado exitosamente.");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            response.put("message", "Error al guardar el libro.");
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> decrementAvailable(Long id) {
        Map<String, String> response = new HashMap<>();

        Book book = bookRepository.findById(id);
        if (book == null) {
            response.put("message", "El libro no existe.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        if (book.getAvailable() <= 0) {
            response.put("message", "No hay stock disponible para el libro.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            bookRepository.decrementAvailable(id);
            response.put("message", "Stock decrementado exitosamente.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error al decrementar el stock.");
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> incrementAvailable(Long id) {
        Map<String, String> response = new HashMap<>();

        Book book = bookRepository.findById(id);
        if (book == null) {
            response.put("message", "El libro no existe.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        try {
            bookRepository.incrementAvailable(id);
            response.put("message", "Stock incrementado exitosamente.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error al incrementar el stock.");
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> delete(Long id) {
        Map<String, String> response = new HashMap<>();

        Book book = bookRepository.findById(id);
        if (book == null) {
            response.put("message", "El libro no existe.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        try {
            bookRepository.delete(id);
            response.put("message", "Libro eliminado exitosamente.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error al eliminar el libro.");
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}