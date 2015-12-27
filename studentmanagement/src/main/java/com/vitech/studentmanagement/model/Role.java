package com.vitech.studentmanagement.model;

import com.vitech.studentmanagement.utility.Constant;

public class Role {
	
	private int id;
	private String userName;
	private String password;
	private String image;
	private String code;
	private String name;
	
	public String checkRole(){
		String roleType = "";
		if(this.userName.indexOf("dbasv") >= 0 || this.userName.indexOf("DBASV") >= 0){
			roleType = Constant.DBASV;
		}
		if(this.userName.indexOf("nv01") >= 0 || this.userName.indexOf("NV01") >= 0){
			roleType = Constant.TPK;
		}
		if(this.userName.indexOf("nv02") >= 0 || this.userName.indexOf("NV02") >= 0){
			roleType = Constant.QLNS;
		}
		if(this.userName.indexOf("nv03") >= 0 || this.userName.indexOf("NV03") >= 0){
			roleType = Constant.HDKH;
		}
		if(this.userName.indexOf("nv04") >= 0 || this.userName.indexOf("NV04") >= 0){
			roleType = Constant.TBM;
		}
		if(this.userName.indexOf("nv05") >= 0 || this.userName.indexOf("NV05") >= 0 
				|| this.userName.indexOf("nv07") >=0 || this.userName.indexOf("NV07") >= 0){
			roleType = Constant.GVU;
		}
		if(this.userName.indexOf("nv06") >= 0 || this.userName.indexOf("NV06") >= 0 
				|| this.userName.indexOf("nv08") >=0 || this.userName.indexOf("NV08") >= 0){
			roleType = Constant.GVI;
		}
		if(this.userName.indexOf("sv01") >= 0 || this.userName.indexOf("SV01") >= 0 
				|| this.userName.indexOf("sv07") >=0 || this.userName.indexOf("SV07") >= 0){
			roleType = Constant.SV;
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
