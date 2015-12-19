package com.vitech.studentmanagement.dao;

import com.vitech.studentmanagement.model.Book;
import com.vitech.studentmanagement.model.BookList;

public interface BookDao {

	public BookList getAll(int index);
	
	public int add(Book book);
	
	public Book find(String code);
	
	public int upate(Book book);
}
