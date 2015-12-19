package com.vitech.studentmanagement.service;

import com.vitech.studentmanagement.model.Book;
import com.vitech.studentmanagement.model.BookList;

public interface BookService {

	public BookList getAll(int index);
	public int add(Book book);
	public Book find(String code);
	public int upate(Book book);
}
