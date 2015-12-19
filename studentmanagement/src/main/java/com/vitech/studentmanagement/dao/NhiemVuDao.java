package com.vitech.studentmanagement.dao;

import java.util.List;

import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.NhiemVu;

public interface NhiemVuDao {

	public List<NhiemVu> find(Employee employee);
}
