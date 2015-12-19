package com.vitech.studentmanagement.model;

public class MyPhoto {

	private String imagePath;
	private String avatarPath;

	public MyPhoto() {

	}

	public MyPhoto(String imagePath, String avatarPath) {
		this.imagePath = imagePath;
		this.avatarPath = avatarPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}
}
