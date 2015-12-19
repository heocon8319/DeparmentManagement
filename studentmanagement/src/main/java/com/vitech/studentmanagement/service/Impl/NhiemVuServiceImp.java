package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.NhiemVuDao;
import com.vitech.studentmanagement.dao.impl.NhiemVuIDaompl;
import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.NhiemVu;
import com.vitech.studentmanagement.service.NhiemVuService;

public class NhiemVuServiceImp implements NhiemVuService{

	private NhiemVuDao nvDao = new NhiemVuIDaompl();

	public List<NhiemVu> find(Employee employee) {
		return nvDao.find(employee);
	}
}
