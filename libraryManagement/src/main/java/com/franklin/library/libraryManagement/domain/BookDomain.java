package com.franklin.library.libraryManagement.domain;


import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Books")
public class BookDomain {
	
	private String id;
	private String title;
	private String author;
	private boolean checkedOut;
	
	public BookDomain() {
		
	}
	
	public BookDomain(String id, String title, String author, boolean checkedOut) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.checkedOut = checkedOut;
	}
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
    @Column(name = "author", nullable = false)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name = "checked_out", nullable = false)
	public boolean isCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	

}
