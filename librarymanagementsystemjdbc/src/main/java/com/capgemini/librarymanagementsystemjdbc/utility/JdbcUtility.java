package com.capgemini.librarymanagementsystemjdbc.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.capgemini.librarymanagementsystemjdbc.exception.LibraryException;

public class JdbcUtility {

	private static Connection connection = null;

	public static Connection getConnection() {
		File file = null;
		FileInputStream inputStream = null;
		file = new File("library.properties");
		try {
			inputStream = new FileInputStream(file);

			Properties properties = new Properties();
			properties.load(inputStream);

			String driver = properties.getProperty("driver");
			String dburl = properties.getProperty("dburl");

			Class.forName(driver);
			connection = DriverManager.getConnection(dburl);

			return connection;

		} catch (FileNotFoundException e) {
			throw new LibraryException("File Not Exists");
		} catch (IOException e) {
			throw new LibraryException("Unable to Read The Data From The File");
		} catch (ClassNotFoundException e) {
			throw new LibraryException("Class Not Loaded");
		} catch (SQLException e) {
			throw new LibraryException("Connection Issue");
		}

	}
}
