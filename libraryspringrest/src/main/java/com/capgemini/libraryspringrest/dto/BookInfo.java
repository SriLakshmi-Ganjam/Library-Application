package com.capgemini.libraryspringrest.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@Entity
@Table(name = "librarybooks")
public class BookInfo implements Serializable {
	@Id
	private int isbn;
	@Column
	private String bookTitle;
	@Column
	private String authourName;
	@Column
	private double price;
	@Column(columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isAvailable;
	
	
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
	
	
//	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "books")
//	private List<RequestInfo> request;
//	

}
