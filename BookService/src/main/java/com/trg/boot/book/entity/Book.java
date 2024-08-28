package com.trg.boot.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	private int bookId;
	@Column(length = 30)
	private String title;
	private int publisherId;
	private int authorId;
	@Column(columnDefinition = "decimal(8,2)")
	private float price;

	public Book() {
		super();
	}

	public Book(int bookId, String title, int publisherId, int authorId, float price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.publisherId = publisherId;
		this.authorId = authorId;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
