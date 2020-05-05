//package com.capgemini.librarymanagementsystemjdbc.utility;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class JdbcUtility {
//
//	private static Connection connection = null;
//
//	public static Connection getConnection() {
//
//		File file = null;
//		FileInputStream inputStream = null;
//		file = new File("library.properties");
//		try {
//			inputStream = new FileInputStream(file);
//
//			Properties properties = new Properties();
//			properties.load(inputStream);
//			Class.forName(properties.getProperty("path"));
//
//			connection = DriverManager.getConnection(properties.getProperty("dburl"));
//
//			return connection;
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//}
