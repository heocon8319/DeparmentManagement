package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.PublisherDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Publisher;
import com.vitech.studentmanagement.utility.Utilities;

public class PublisherDaoImpl implements PublisherDao {

	public List<Publisher> getAll() {
		List<Publisher> publishers = new ArrayList<Publisher>();
		String sql = "select * from publisher where status = ?";
		try {
			Connection connection = DBProvider.connectDB();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, Utilities.STATUS_ACTIVE);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String status = resultSet.getString("status");
				Publisher publisher = new Publisher(id, name, status);
				publishers.add(publisher);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publishers;
	}

}
