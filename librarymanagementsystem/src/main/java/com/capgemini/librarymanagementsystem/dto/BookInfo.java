package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookInfo implements Serializable{
	private int isbn;
	private String bookTitle;
	private String authourName;
	private double price;
	private boolean isAvailable;
	
	public BookInfo() {
		super();
	}
		
	public BookInfo(int isbn, String bookTitle, String authourName, double price, boolean isAvailable) {
		super();
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.authourName = authourName;
		this.price = price;
		this.isAvailable = isAvailable;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public String getAuthourName() {
		return authourName;
	}
	public void setAuthourName(String authourName) {
		this.authourName = authourName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "BookInfo [isbn=" + isbn + ", bookTitle=" + bookTitle + ", authourName=" + authourName + ", price="
				+ price + ", isAvailable=" + isAvailable + "]";
	}
	
	

}
