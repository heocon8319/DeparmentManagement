package com.vitech.studentmanagement.service.Impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FilenameUtils;

import com.vitech.studentmanagement.dao.BookDao;
import com.vitech.studentmanagement.dao.impl.BookDaoImpl;
import com.vitech.studentmanagement.model.Book;
import com.vitech.studentmanagement.model.BookList;
import com.vitech.studentmanagement.model.MyPhoto;
import com.vitech.studentmanagement.service.BookService;
import com.vitech.studentmanagement.utility.Utilities;

public class BookServiceImpl implements BookService {

	BookDao bookDao = new BookDaoImpl();

	public BookList getAll(int index) {
		return bookDao.getAll(index);
	}

	public int add(Book book) {
		MyPhoto myPhoto = coppyFile(book);
		book.setAvatar(myPhoto.getAvatarPath());
		book.setImage(myPhoto.getImagePath());
		book.setCreatedDate(Utilities.getCurrentDate());
		return bookDao.add(book);
	}

	public MyPhoto coppyFile(Book book) {
		MyPhoto myPhoto = new MyPhoto();
		try {
			String random = Utilities.randomTime();
			String fileName = random+FilenameUtils.getName(book.getAvatar());
			File source = new File(book.getAvatar());
			//create avatar for book;
			File destAvatar = new File(Utilities.BOOK_AVATAR+ fileName);
			Files.copy(source.toPath(), destAvatar.toPath(), StandardCopyOption.REPLACE_EXISTING);
			myPhoto.setAvatarPath(destAvatar.getPath());
			//create image for book;
			String destImage = Utilities.resizeImage(source, fileName);	
			myPhoto.setImagePath(destImage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myPhoto;
	}

	public Book find(String code) {
		return bookDao.find(code);
	}

	public int upate(Book book) {
		Book oldBook = bookDao.find(book.getCode());
		//if avatar was changed then must update new avatar and image;
		if(!oldBook.getAvatar().equals(book.getAvatar())){
			//delete old avatar;
			File destAvatar = new File(oldBook.getAvatar());
			destAvatar.delete();
			//delete old image;
			File destImage = new File(oldBook.getImage());
			destImage.delete();
			//update new avatar;
			MyPhoto myPhoto = coppyFile(book);
			book.setAvatar(myPhoto.getAvatarPath());
			book.setImage(myPhoto.getImagePath());
		}else{
			book.setImage(oldBook.getImage());
		}
		return bookDao.upate(book);
	}
}
