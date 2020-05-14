package com.codegym.Service;

import com.codegym.model.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Iterable<Book> findAllBook();
    Book findByIdBook(Long id);
    void createBook(Book book);
    void remove(Long id);
}
