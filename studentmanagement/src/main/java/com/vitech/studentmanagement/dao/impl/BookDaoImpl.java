package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.BookDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Book;
import com.vitech.studentmanagement.model.BookList;
import com.vitech.studentmanagement.model.Paging;
import com.vitech.studentmanagement.utility.Utilities;

public class BookDaoImpl implements BookDao {
	
	public int getTotalRows(){
		int count = 0;
		String sql = "select count(*) from book where status = ?";
		try {
			Connection connection = DBProvider.connectDB();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, Utilities.STATUS_ACTIVE);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			count = resultSet.getInt(1);
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public BookList getAll(int index) {
		BookList booklist = new BookList();
		int totalRow = getTotalRows();
		Paging paging = new Paging(totalRow);
		paging.setCurrentIndex(index);
		booklist.setTotalPage(paging.getTotalPage());
		
		StringBuilder sql = new StringBuilder(
				"select b.*, p.name as publisher, k.name as kind from book b, publisher p, kindofbook k ")
				.append("where b.status = ? and b.publisher_id=p.id and b.kind_id = k.id ")
				.append("order by id limit ?, ? ");
		List<Book> books = new ArrayList<Book>();
		try {
			Connection connection = DBProvider.connectDB();
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, Utilities.STATUS_ACTIVE);
			preparedStatement.setInt(2, paging.startIndex());
			preparedStatement.setInt(3, paging.getRowPerPage());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String code = resultSet.getString("code");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				String image = resultSet.getString("image");
				int amount = resultSet.getInt("amount");
				String status = resultSet.getString("status");
				String publisher = resultSet.getString("publisher");
				String kind = resultSet.getString("kind");
				Book book = new Book(id, code, title, author, image, amount, status, publisher, kind);
				books.add(book);
			}
			preparedStatement.close();
			connection.close();
			booklist.setBooks(books);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return booklist;
	}

	public int add(Book book) {
		StringBuilder sql = new StringBuilder("insert into book(code, title, author, image, avatar, amount, status, publisher_id, kind_id, created_date) ")
		.append("values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		int result = 0;
		try {
			Connection connection = DBProvider.connectDB();
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, book.getCode());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4, book.getImage());
			preparedStatement.setString(5, book.getAvatar());
			preparedStatement.setInt(6, book.getAmount());
			preparedStatement.setString(7, book.getStatus());
			preparedStatement.setInt(8, book.getPublisherId());
			preparedStatement.setInt(9, book.getKindId());
			preparedStatement.setString(10, book.getCreatedDate());
			result = preparedStatement.executeUpdate();
			if (result == 1) {
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					result = generatedKeys.getInt(1);
				}
			}
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Book find(String code) {
		String sql = new String("select * from book where status = ? and code = ?");
		Book book = null;
		try {
			Connection connection = DBProvider.connectDB();
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, Utilities.STATUS_ACTIVE);
			preparedStatement.setString(2, code);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int publisherId = resultSet.getInt("publisher_id");
				int kindId = resultSet.getInt("kind_id");
				int amount = resultSet.getInt("amount");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				String avatar = resultSet.getString("avatar");
				String image = resultSet.getString("image");
				book = new Book(code, title, author, amount, publisherId, kindId, avatar);
				book.setImage(image);
			}
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	public int upate(Book book) {
		int result = 0;
		String sql = new String("update book set publisher_id = ?, kind_id = ?, amount = ?, title = ?, author = ?, image = ?, avatar = ?  where status = ? and code = ?");
		try {
			Connection connection = DBProvider.connectDB();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, book.getPublisherId());
			preparedStatement.setInt(2, book.getKindId());
			preparedStatement.setInt(3, book.getAmount());
			preparedStatement.setString(4, book.getTitle());
			preparedStatement.setString(5, book.getAuthor());
			preparedStatement.setString(6, book.getImage());
			preparedStatement.setString(7, book.getAvatar());
			preparedStatement.setString(8, Utilities.STATUS_ACTIVE);
			preparedStatement.setString(9, book.getCode());
			result = preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
