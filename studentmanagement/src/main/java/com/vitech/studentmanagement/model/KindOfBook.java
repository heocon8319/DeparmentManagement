package com.vitech.studentmanagement.model;

public class KindOfBook {

	private int id;
	private String name;
	private String status;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public KindOfBook(int id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
}
