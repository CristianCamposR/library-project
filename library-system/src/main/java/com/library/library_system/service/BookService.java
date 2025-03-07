package com.library.library_system.service;

import com.library.library_system.model.Book;
import com.library.library_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired // Inyecta el repositorio
    private BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    public void save(Book book) {
        if (book.getId() == null) {
            bookRepository.insert(book); // Insertar nuevo libro
        } else {
            bookRepository.update(book); // Actualizar libro existente
        }
    }

    public boolean decrementAvailable(Long id) {
        return bookRepository.decrementAvailable(id) > 0;
    }

    public boolean incrementAvailable(Long id) {
        return bookRepository.incrementAvailable(id) > 0;
    }

    public void delete(Long id) {
        bookRepository.delete(id);
    }
}
