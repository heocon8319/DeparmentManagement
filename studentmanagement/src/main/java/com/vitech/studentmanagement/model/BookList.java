package com.vitech.studentmanagement.model;

import java.util.List;

public class BookList {
	
	private List<Book> books;
	private int totalPage;

	public List<Book> getBooks() {
		return books;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
