package com.franklin.library.libraryManagement.service;

import com.franklin.library.libraryManagement.dao.BookDao;
import com.franklin.library.libraryManagement.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("bookDao") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int insertBook(Book book){
        return bookDao.insertBook(book);
    }

    public List<Book> getAllBooks(){
        return bookDao.selectAllBooks();
    }

    public Book getBookById(UUID id){
        return bookDao.selectBookById(id);
    }

    public int deleteBook(UUID id){
        return bookDao.deleteBookById(id);
    }

    public int updateBook(UUID id, Book newBook){
        return bookDao.updateBookById(id, newBook);
    }
}
