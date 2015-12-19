package com.vitech.studentmanagement.utility;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Utilities {

	public static ImageIcon WINDOW_ICON = new ImageIcon(
			Utilities.class.getResource("/app/management-icon.png"));

	// JDBC driver name and database URL
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/vitechlibrary";

	// OJDBC driver name and database URL
	public static final String OJDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String ODB_URL = "jdbc:oracle:thin:@localhost:1521:QLSV";

	// Database credentials
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "";

	// User role;
	public static String STATUS_ACTIVE = "active";

	public static String BOOK_AVATAR = "\\Volumes\\MyData\\Education\\TechnicalProgramming\\ViTechLibrary\\book\\avatar\\";
	public static String BOOK_IMAGE = "\\Volumes\\MyData\\Education\\TechnicalProgramming\\ViTechLibrary\\book\\image\\";

	public static int ROWS_PER_PAGE = 15;

	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String randomTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String encodePassword(String password) {
		String encoded = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes(), 0, password.length());
			encoded = new BigInteger(1, md5.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encoded;
	}

	public static String resizeImage(File fileOriginal, String fileName) {
		String result = "";
		try {
			int IMG_WIDTH = 24;
			int IMG_HEIGHT = 24;
			BufferedImage originalImage = ImageIO.read(fileOriginal);
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
					: originalImage.getType();
			BufferedImage resizedImage = new BufferedImage(IMG_WIDTH,
					IMG_HEIGHT, type);
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
			g.dispose();

			File destImage = new File(Utilities.BOOK_IMAGE + fileName);
			ImageIO.write(resizedImage, "png", destImage);
			result = destImage.getPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
