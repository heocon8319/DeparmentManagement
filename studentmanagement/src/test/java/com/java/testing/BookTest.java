package com.java.testing;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;

import com.vitech.studentmanagement.dao.BookDao;
import com.vitech.studentmanagement.dao.impl.BookDaoImpl;
import com.vitech.studentmanagement.model.Book;
import com.vitech.studentmanagement.service.BookService;
import com.vitech.studentmanagement.service.Impl.BookServiceImpl;

public class BookTest {

	BookService s = new BookServiceImpl();

	public void getAll() {
		// Vector<Vector> rowData = s.getAll(1);
		// for(int i=0; i<rowData.size(); i++){
		// System.out.println("----------");
		// Vector<Book> v = rowData.get(i);
		// System.out.println(v.get(0));
		// System.out.println(v.get(1));
		// System.out.println(v.get(2));
		// System.out.println(v.get(3));
		// }
	}

	public static BufferedImage resizeImage(BufferedImage originalImage, int type) {
		int IMG_WIDTH = 24;
		int IMG_HEIGHT = 24;
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		return resizedImage;
	}

	public static void main(String[] agrs) {
		try {
			BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\nhutnguyencm\\Desktop\\Books-icon.png"));
			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			BufferedImage resizeImagePng = resizeImage(originalImage, type);
			ImageIO.write(resizeImagePng, "png", new File("C:\\Users\\nhutnguyencm\\Desktop\\mkyong.jpg")); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
