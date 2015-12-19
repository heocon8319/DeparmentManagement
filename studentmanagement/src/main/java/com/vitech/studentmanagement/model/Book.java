package com.vitech.studentmanagement.model;

import com.vitech.studentmanagement.utility.Utilities;

public class Book {

	private int id;
	private String code;
	private String title;
	private String author;
	private String image;
	private int amount;
	private String status = Utilities.STATUS_ACTIVE;
	private String createdDate;
	
	private String publisher;
	private String kind;
	
	private int publisherId;
	private int kindId;
	
	private String avatar;
	public Book(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Book(int id, String code, String title, String author, String image,
			int amount, String status, String publisher, String kind) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.author = author;
		this.image = image;
		this.amount = amount;
		this.status = status;
		this.publisher = publisher;
		this.kind = kind;
	}

	public Book(String code, String title, String author, int amount,
			int publisherId, int kindId, String avatar) {
		super();
		this.code = code;
		this.title = title;
		this.author = author;
		this.amount = amount;
		this.publisherId = publisherId;
		this.kindId = kindId;
		this.avatar = avatar;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public int getKindId() {
		return kindId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public void setKindId(int kindId) {
		this.kindId = kindId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
