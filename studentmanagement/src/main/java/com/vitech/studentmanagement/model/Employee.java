package com.vitech.studentmanagement.model;

import com.vitech.studentmanagement.utility.Utilities;

public class Employee {

	private int id;
	private String code;
	private String name;
	private String userName;
	private String password;
	private String identify;
	private String phone;
	private String image;
	private String DOB;
	private String createdDate;
	private String status = Utilities.STATUS_ACTIVE;
	private int role;

	public Employee(){
	
	}
	
	public Employee(int id, String code, String name, String image, int role) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.image = image;
		this.role = role;
	}

	public Employee(String code, String name, String userName, String password,
			String identify, String phone, String image, String dOB, int role) {
		this.code = code;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.identify = identify;
		this.phone = phone;
		this.image = image;
		DOB = dOB;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
