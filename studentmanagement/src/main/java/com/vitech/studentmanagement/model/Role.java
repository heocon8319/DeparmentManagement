package com.vitech.studentmanagement.model;

public class Role {
	
	private int id;
	private String userName;
	private String password;
	private String image;
	private String code;
	private String name;
	
	public int checkRole(){
		/*
		 * SV = 1;
		 * DBASV = 2;
		 * NV_TPK = 3;
		 * NV_QLNS = 4;
		 */
		int roleType = 1;
		if(this.userName.indexOf("dbasv") >= 0 || this.userName.indexOf("DBASV") >= 0){
			roleType = 2;
		}
		if(this.userName.indexOf("nv01") >= 0 || this.userName.indexOf("NV01") >= 0){
			roleType = 3;
		}
		if(this.userName.indexOf("nv02") >= 0 || this.userName.indexOf("NV02") >= 0){
			roleType = 4;
		}
		return roleType;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
}
