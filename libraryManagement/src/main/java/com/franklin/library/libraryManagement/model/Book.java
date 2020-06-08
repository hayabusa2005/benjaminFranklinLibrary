package com.franklin.library.libraryManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import javax.persistence.Column;

public class Book {

	private UUID id;
	private String title;
	private String author;
	private boolean checkedOut;

	public Book(@JsonProperty("id") UUID id, @JsonProperty("title") String title, @JsonProperty("author") String author,
			@JsonProperty("checkedOut") boolean checkedOut) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.checkedOut = checkedOut;

	}
	
	public Book() {}
	
	public boolean isCheckedOut() {
		return checkedOut;
	}

	public String getAuthor() {
		return author;
	}

	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
}
