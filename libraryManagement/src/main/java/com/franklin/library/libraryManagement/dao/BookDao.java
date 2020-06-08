package com.franklin.library.libraryManagement.dao;

import com.franklin.library.libraryManagement.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookDao {

    int insertBook(Book book);

    Book selectBookById(UUID id);

    List<Book> selectAllBooks();

    int deleteBookById(UUID id);

    int updateBookById(UUID id, Book book);
}
