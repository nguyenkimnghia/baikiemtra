package com.codegym.Service.impl;

import com.codegym.Service.BookService;
import com.codegym.model.Book;
import com.codegym.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Iterable<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByIdBook(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }


}
