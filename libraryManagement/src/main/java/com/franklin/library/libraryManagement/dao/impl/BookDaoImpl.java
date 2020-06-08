package com.franklin.library.libraryManagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.franklin.library.libraryManagement.dao.BookDao;
import com.franklin.library.libraryManagement.domain.BookDomain;
import com.franklin.library.libraryManagement.model.Book;
import com.franklin.library.libraryManagement.repository.BookRepository;

@Component(value = "bookDao")
public class BookDaoImpl implements BookDao{
    private final String UPDATE_BOOK = "UPDATE books " + 
    		"SET author = ?, title = ?, checked_out = ? " + 
    		"WHERE id = ?;";
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    BookRepository bookRepository;
    
    DozerBeanMapper mapper;
    
    @Override
    public int insertBook(Book book) {
    	if(book.getId() == null) {
    		book.setId(UUID.randomUUID());
    	}
        BookDomain bookForDb = new DozerBeanMapper().map(book, BookDomain.class);
        bookRepository.save(bookForDb);
        return 1;
    }

    @Override
    public Book selectBookById(UUID id) {
    	BookDomain bookReturned = bookRepository.findById(id.toString()).get();
    	Book bookForResponse = mapDbToModel(bookReturned);
    	return bookForResponse;
    }

    @Override
    public List<Book> selectAllBooks() {
        List<BookDomain> booksReturned = (List<BookDomain>) bookRepository.findAll();
        List<Book> booksForResponse = new ArrayList<Book>(); 
        booksReturned.stream()
        		.forEach(book -> {
        			Book bookForResponse = mapDbToModel(book);
        			booksForResponse.add(bookForResponse);});
        			
        return booksForResponse;
    }

    @Override
    public int deleteBookById(UUID id) {
    	bookRepository.deleteById(id.toString());
    	return 1;
    	
    }

    @Override
    public int updateBookById(UUID id, Book book) {
    	return jdbcTemplate.update(UPDATE_BOOK, book.getAuthor(), book.getTitle(), book.isCheckedOut(),
    									id.toString());        
    }
    
    private Book mapDbToModel(BookDomain bookDb) {
    	Book book = new Book();
    	book.setAuthor(bookDb.getAuthor());
    	book.setCheckedOut(bookDb.isCheckedOut());
    	book.setId(UUID.fromString(bookDb.getId()));
    	book.setTitle(bookDb.getTitle());
    	return book;
    }
}
