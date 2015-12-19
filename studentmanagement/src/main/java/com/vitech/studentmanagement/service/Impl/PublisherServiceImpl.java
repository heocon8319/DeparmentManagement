package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.PublisherDao;
import com.vitech.studentmanagement.dao.impl.PublisherDaoImpl;
import com.vitech.studentmanagement.model.Publisher;
import com.vitech.studentmanagement.service.PublisherService;

public class PublisherServiceImpl implements PublisherService{

	PublisherDao publisherDao = new PublisherDaoImpl();
	public List<Publisher> getAll() {
		return publisherDao.getAll();
	}

}
