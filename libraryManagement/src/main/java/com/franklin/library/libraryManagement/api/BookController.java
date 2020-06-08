package com.franklin.library.libraryManagement.api;

import com.franklin.library.libraryManagement.model.Book;
import com.franklin.library.libraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
API layer that controls interaction with the request for the Benjamin Franklin
Library
 */
@RequestMapping("/api/v1/book")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.insertBook(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Access-Control-Allow-Origin", "*");
    	return new ResponseEntity<List<Book>>(bookService.getAllBooks(), 
    			headers, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public Book getBookById(@PathVariable("id") UUID id){
        return bookService.getBookById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBookById(@PathVariable("id") UUID id){
        bookService.deleteBook(id);
    }

    @PutMapping(path = "{id}")
    public void updateBookById(@PathVariable("id") UUID id, @RequestBody Book bookToUpdate){
        bookService.updateBook(id, bookToUpdate);
    }
}
