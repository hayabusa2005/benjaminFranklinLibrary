package com.franklin.library.libraryManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.franklin.library.libraryManagement.domain.BookDomain;

@Repository
public interface BookRepository extends CrudRepository<BookDomain, String> {
	
	List<BookDomain> findByTitle(String title);
	List<BookDomain> findByAuthor(String author);
}