package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.NhiemVu;

public interface NhiemVuService {

	public List<NhiemVu> find(Employee employee);
}
