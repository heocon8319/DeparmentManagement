package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.KindOfBookDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.KindOfBook;
import com.vitech.studentmanagement.utility.Utilities;

public class KindOfBookDaoImpl implements KindOfBookDao{

	public List<KindOfBook> getAll() {
		List<KindOfBook> kindOfBooks = new ArrayList<KindOfBook>();
		String sql = "select * from kindofbook where status = ?";
		try {
			Connection connection = DBProvider.connectDB();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, Utilities.STATUS_ACTIVE);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String status = resultSet.getString("status");
				KindOfBook kindOfBook = new KindOfBook(id, name, status);
				kindOfBooks.add(kindOfBook);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kindOfBooks;
	}

}
