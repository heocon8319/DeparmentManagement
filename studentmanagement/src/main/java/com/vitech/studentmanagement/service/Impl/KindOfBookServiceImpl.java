package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.KindOfBookDao;
import com.vitech.studentmanagement.dao.impl.KindOfBookDaoImpl;
import com.vitech.studentmanagement.model.KindOfBook;
import com.vitech.studentmanagement.service.KindOfBookService;

public class KindOfBookServiceImpl implements KindOfBookService {

	KindOfBookDao kindOfBookDao = new KindOfBookDaoImpl();

	public List<KindOfBook> getAll() {
		return kindOfBookDao.getAll();
	}

}
