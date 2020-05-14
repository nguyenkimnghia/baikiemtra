package com.codegym.controller;

import com.codegym.Service.BookService;
import com.codegym.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin("*")
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<Iterable<Book>> getAllProduct(){
        return new ResponseEntity<>(bookService.findAllBook(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getCustomer(@PathVariable("id") long id) {
       Book customer = bookService.findByIdBook(id);
        if (customer == null) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(customer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody Book book) {
        bookService.createBook(book);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Book> updateCustomer(@PathVariable("id") long id, @RequestBody Book book) {
        Book bookForm = bookService.findByIdBook(id);

        if (bookForm == null) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        bookForm.setName(book.getName());
        bookForm.setAuthor(book.getAuthor());
        bookForm.setDecent(book.getDecent());
        bookForm.setId(book.getId());
        bookService.createBook(bookForm);
        return new ResponseEntity<Book>(bookForm, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Book> deleteCustomer(@PathVariable("id") long id) {
        Book customer = bookService.findByIdBook(id);
        if (customer == null) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        bookService.remove(id);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }
}
