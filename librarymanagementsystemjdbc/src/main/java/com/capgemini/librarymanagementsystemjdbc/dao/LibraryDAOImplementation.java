package com.capgemini.librarymanagementsystemjdbc.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.capgemini.librarymanagementsystemjdbc.dto.BookInfo;
import com.capgemini.librarymanagementsystemjdbc.dto.LibraryUsers;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestInfo;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryException;

public class LibraryDAOImplementation implements LibraryDAO {
	int noOfRowsAffected;

	@Override
	public boolean register(LibraryUsers user) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			FileInputStream file = new FileInputStream("library.properties");
			Properties properties = new Properties();
			properties.load(file);

			Class.forName(properties.getProperty("driver"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"));

			statement = connection.prepareStatement(properties.getProperty("insertQuery"));

			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmailId());
			statement.setString(4, user.getPassword());
			statement.setInt(5, user.getNoOfBooksBorrowed());
			statement.setString(6, user.getRole());

			noOfRowsAffected = statement.executeUpdate();
//			System.out.println(noOfRowsAffected);

			if (noOfRowsAffected != 0) {
				return true;
			} else {
				throw new LibraryException("User Already Exists");
			}

		} catch (Exception e) {
			throw new LibraryException("User Already Exists");
		} finally {

			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public LibraryUsers authentication(int id, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		LibraryUsers users = new LibraryUsers();

		try {
			FileInputStream file = new FileInputStream("library.properties");
			Properties properties = new Properties();
			properties.load(file);

			Class.forName(properties.getProperty("driver"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"));

			statement = connection.prepareStatement(properties.getProperty("login"));

			statement.setInt(1, id);
			statement.setString(2, password);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				users.setId(resultSet.getInt("id"));
				users.setPassword(resultSet.getString("password"));
				users.setEmailId(resultSet.getString("emailId"));
				users.setName(resultSet.getString("name"));
				users.setRole(resultSet.getString("role"));
				users.setNoOfBooksBorrowed(resultSet.getInt("noOfBooksBorrowed"));
				return users;
			}
			throw new LibraryException("Invalid Credentials");
		} catch (Exception e) {
			throw new LibraryException("Invalid  Credentials");
		} finally {

			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean addBook(BookInfo book) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			FileInputStream file = new FileInputStream("library.properties");
			Properties properties = new Properties();
			properties.load(file);

			Class.forName(properties.getProperty("driver"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"));

			statement = connection.prepareStatement(properties.getProperty("insertBook"));

			statement.setInt(1, book.getIsbn());
			statement.setString(2, book.getBookTitle());
			statement.setString(3, book.getAuthourName());
			statement.setDouble(4, book.getPrice());
			statement.setBoolean(5, book.isAvailable());

			noOfRowsAffected = statement.executeUpdate();

			if (noOfRowsAffected != 0) {
				return true;
			} else {
				throw new LibraryException("Book Cannot be Inserted");
			}
		} catch (Exception e) {
			throw new LibraryException("Book Id Already Exits");
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean deleteBook(int isbn) {

		try (FileInputStream file = new FileInputStream("library.properties")) {
			Properties properties = new Properties();
			properties.load(file);

			Class.forName(properties.getProperty("driver"));

			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"));
					PreparedStatement statement = connection.prepareStatement(properties.getProperty("deleteBook"))) {

				statement.setInt(1, isbn);

				noOfRowsAffected = statement.executeUpdate();

				if (noOfRowsAffected != 0) {
					return true;
				} else {
					throw new LibraryException("Book Id Not Exists for Delete");
				}

			} catch (SQLException e) { // Connection try resource
				e.printStackTrace();
				throw new LibraryException("Book Id Not Exists for Delete");
			}

		} catch (FileNotFoundException e) { // FileInputStream try resource
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e1) { // Class.forname exception
			e1.printStackTrace();
			return false;
		}

	}

	@Override
	public List<BookInfo> showBooks() {
		try (FileInputStream file = new FileInputStream("library.properties")) {
			Properties properties = new Properties();
			properties.load(file);

			Class.forName(properties.getProperty("driver"));

			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"));
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(properties.getProperty("showBooks"))) {

				List<BookInfo> list = new LinkedList<BookInfo>();

				while (resultSet.next()) {
					BookInfo bookInfo = new BookInfo();

					bookInfo.setIsbn(resultSet.getInt("isbn"));
					bookInfo.setBookTitle(resultSet.getString("bookTitle"));
					bookInfo.setAuthourName(resultSet.getString("authourName"));
					bookInfo.setPrice(resultSet.getDouble("price"));
					bookInfo.setAvailable(resultSet.getBoolean("isAvailable"));

					list.add(bookInfo);
				}
				return list;

			}
		} catch (Exception e) {
			throw new LibraryException("No List Found");
		}

	}

	@Override
	public List<BookInfo> search(BookInfo bookInfo) {

		if (bookInfo.getIsbn() != 0) {
			try (FileInputStream file = new FileInputStream("library.properties")) {
				Properties properties = new Properties();
				properties.load(file);

				Class.forName(properties.getProperty("driver"));

				try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"));
						PreparedStatement statement = connection
								.prepareStatement(properties.getProperty("searchBookById"))) {

					statement.setInt(1, bookInfo.getIsbn());
					try (ResultSet resultSet = statement.executeQuery()) {

						List<BookInfo> list = new LinkedList<BookInfo>();

						if (resultSet.next()) {
							BookInfo book = new BookInfo();

							book.setIsbn(resultSet.getInt("isbn"));
							book.setBookTitle(resultSet.getString("bookTitle"));
							book.setAuthourName(resultSet.getString("authourName"));
							book.setPrice(resultSet.getDouble("price"));
							book.setAvailable(resultSet.getBoolean("isAvailable"));

							list.add(book);

							return list;
						} else {
							throw new LibraryException("No Book Found With The Given Id");
						}
					} // End Of Try Resource Result Set

				} // End Of Try Resource Connection

			} // End of Try Resources BookId Search
			catch (Exception e) {
				throw new LibraryException("No Book Found With The Given Id");
			}
		} else if (bookInfo.getBookTitle() != null) {
			try (FileInputStream file = new FileInputStream("library.properties")) {
				Properties properties = new Properties();
				properties.load(file);

				try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"));
						PreparedStatement statement = connection
								.prepareStatement(properties.getProperty("searchBookByTitle"))) {
					statement.setString(1, bookInfo.getBookTitle());
					try (ResultSet resultSet = statement.executeQuery()) {
						List<BookInfo> list = new LinkedList<BookInfo>();

						while (resultSet.next()) {
							BookInfo book = new BookInfo();

							book.setIsbn(resultSet.getInt("isbn"));
							book.setBookTitle(resultSet.getString("bookTitle"));
							book.setAuthourName(resultSet.getString("authourName"));
							book.setPrice(resultSet.getDouble("price"));
							book.setAvailable(resultSet.getBoolean("isAvailable"));

							list.add(book);

						}
						return list;

					} // End Of Try Resource Result Set
				} // End Of Try Resource Connection, Prepared Statement
			} // End Of Try Resources File Input Stream
			catch (Exception e) {
				throw new LibraryException("No Books Found With Given Name");
			}
		} else if (bookInfo.getAuthourName() != null) {
			try (FileInputStream file = new FileInputStream("library.properties")) {
				Properties properties = new Properties();
				properties.load(file);

				try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"));
						PreparedStatement statement = connection
								.prepareStatement(properties.getProperty("searchBookByAuthour"))) {
					statement.setString(1, bookInfo.getAuthourName());
					try (ResultSet resultSet = statement.executeQuery()) {
						List<BookInfo> list = new LinkedList<BookInfo>();

						while (resultSet.next()) {
							BookInfo book = new BookInfo();

							book.setIsbn(resultSet.getInt("isbn"));
							book.setBookTitle(resultSet.getString("bookTitle"));
							book.setAuthourName(resultSet.getString("authourName"));
							book.setPrice(resultSet.getDouble("price"));
							book.setAvailable(resultSet.getBoolean("isAvailable"));

							list.add(book);

						}
						return list;

					} // End Of Try Resource Result Set
				} // End Of Try Resource Connection, Prepared Statement
			} // End Of Try Resources File Input Stream
			catch (Exception e) {
				throw new LibraryException("No Books Found With Given Authour");
			}
		} else {
			throw new LibraryException("Book Not Found");
		}

	} // End Of Book Search

	@Override
	public List<LibraryUsers> showUsers() {
		try (FileInputStream file = new FileInputStream("library.properties")) {
			Properties properties = new Properties();
			properties.load(file);

			Class.forName(properties.getProperty("driver"));

			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"));
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(properties.getProperty("showUsers"))) {

				List<LibraryUsers> list = new LinkedList<LibraryUsers>();

				while (resultSet.next()) {
					LibraryUsers users = new LibraryUsers();

					users.setId(resultSet.getInt("id"));
					users.setName(resultSet.getString("name"));
					users.setEmailId(resultSet.getString("emailId"));
					users.setNoOfBooksBorrowed(resultSet.getInt("noOfBooksBorrowed"));
					users.setRole(resultSet.getString("role"));

					list.add(users);
				}
				return list;

			}
		} catch (Exception e) {
			throw new LibraryException("No Users Found");
		}

	}

	@Override
	public RequestInfo bookRequest(int userId, int bookId) {
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		//PreparedStatement statement2 =  null;
		ResultSet resultSet = null;
		boolean isavail = false;
		//int noOfRequests = 0;
		try (FileInputStream file = new FileInputStream("library.properties")) {
			Properties properties = new Properties();
			properties.load(file);
			Class.forName(properties.getProperty("driver"));
			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"))) {
				
//				statement2 = connection.prepareStatement(properties.getProperty("countRequests"));
//				statement2.setInt(1, userId);
//				resultSet = statement2.executeQuery();
//				
				

				statement = connection.prepareStatement(properties.getProperty("checkAvailability"));
				statement.setInt(1, bookId);
				resultSet = statement.executeQuery();

				System.out.println("outof avial");
				while (resultSet.next()) {
					isavail = resultSet.getBoolean(1);
					System.out.println(isavail);
				}
				if (isavail) {
					statement1 = connection.prepareStatement(properties.getProperty("insertBookRequest"));
					statement1.setInt(1, userId);
					statement1.setInt(2, bookId);

					noOfRowsAffected = statement1.executeUpdate();
					if (noOfRowsAffected != 0) {
						RequestInfo requestInfo = new RequestInfo();

						requestInfo.setUserId(userId);
						requestInfo.setBookId(bookId);

						return requestInfo;

					} else {
						throw new LibraryException("Request Cannot Be Placed");
					}
				} else {
					throw new LibraryException("This Book Is Not Available For Borrowing");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new LibraryException("Request Cannot Be Placed");
		}

	}

	@Override
	public List<RequestInfo> showRequests() {
		try (FileInputStream file = new FileInputStream("library.properties")) {
			Properties properties = new Properties();
			properties.load(file);

			Class.forName(properties.getProperty("driver"));

			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"));
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(properties.getProperty("showRequests"))) {

				List<RequestInfo> list = new LinkedList<RequestInfo>();

				while (resultSet.next()) {
					RequestInfo requestInfo = new RequestInfo();

					requestInfo.setRequestId(resultSet.getInt("requestId"));
					requestInfo.setUserId(resultSet.getInt("userId"));
					requestInfo.setBookId(resultSet.getInt("bookId"));
					requestInfo.setIssuedDate(resultSet.getDate("issuedDate"));
					requestInfo.setExpectedReturnedDate(resultSet.getDate("expectedReturnDate"));
					requestInfo.setReturnedDate(resultSet.getDate("returnedDate"));
					requestInfo.setFine(resultSet.getDouble("fine"));

					list.add(requestInfo);
				}
				return list;

			}
		} catch (Exception e) {
			throw new LibraryException("No Lists Found");
		}
	}

	@SuppressWarnings("resource")
	@Override
	public boolean isBookIssued(int requestId) {
		PreparedStatement statement = null;
		; // , statement1, statement2, statement3, statement4;
		ResultSet resultSet = null; // , resultSet1, resultSet2, resultSet3, resultSet4, resultSet5;
		try (FileInputStream file = new FileInputStream("library.properties")) {
			Properties properties = new Properties();
			properties.load(file);

			Class.forName(properties.getProperty("driver"));

			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"))) {
				statement = connection.prepareStatement(properties.getProperty("getRequest"));
				statement.setInt(1, requestId);
				resultSet = statement.executeQuery();
				if (resultSet.next()) {
					RequestInfo info = new RequestInfo();
					info.setUserId(resultSet.getInt("userId"));
					info.setBookId(resultSet.getInt("bookId"));

					int requestUserId = info.getUserId();
					int requestBookId = resultSet.getInt("bookId");
					if (requestUserId != 0) {
						statement = connection.prepareStatement(properties.getProperty("getUser"));

						statement.setInt(1, requestUserId);
						resultSet = statement.executeQuery();

						if (resultSet.next()) {
							LibraryUsers users = new LibraryUsers();
							users.setNoOfBooksBorrowed(resultSet.getInt("noOfBooksBorrowed"));
							int noOfBooksBorrowed = users.getNoOfBooksBorrowed();
							System.out.println("no of books Before issue	" + noOfBooksBorrowed);
							if (noOfBooksBorrowed < 3) {

								statement = connection.prepareStatement(properties.getProperty("issueBook"));

								statement.setInt(1, requestId);
								int updateDate = statement.executeUpdate();
								if (updateDate != 0) {
									System.out.println("Dates updated succesfully");
									System.out.println();

									// Update book availability as false as we are issuing
									statement = connection
											.prepareStatement(properties.getProperty("setBookAvailability"));
									statement.setInt(1, requestBookId);
									statement.executeUpdate();

									// Update User no of books borrowed
									noOfBooksBorrowed++;
									statement = connection
											.prepareStatement(properties.getProperty("setNoOfBooksBorrowed"));
									statement.setInt(1, noOfBooksBorrowed);
									statement.setInt(2, requestUserId);
									statement.executeUpdate();

								} // End of if update date!=0

								return true;

							} else {
								throw new LibraryException(
										"Maximum Borrowed Books Limt Exceeds, Please Return Preveios Books");
							}

						} else {
							throw new LibraryException("Invalid User");
						}

					} else {
						throw new LibraryException("Invalid User");
					}

				} else {
					throw new LibraryException("InValid Request Id");
				}

			} // End Of Connection

		} catch (Exception e) {
			throw new LibraryException("Invalid Request");

		} finally {
			try {

				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@SuppressWarnings("resource")
	@Override
	public boolean bookReturn(int userId, int bookId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try (FileInputStream file = new FileInputStream("library.properties")) {
			Properties properties = new Properties();
			properties.load(file);
			Class.forName(properties.getProperty("driver"));

			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"))) {
				statement = connection.prepareStatement(properties.getProperty("bookReturn"));

				statement.setInt(1, userId);
				statement.setInt(2, bookId);

				resultSet = statement.executeQuery();

				if (resultSet.next() != false) {
					int requestId = resultSet.getInt("requestId");
					System.out.println("Request Id" + requestId);

					statement = connection.prepareStatement(properties.getProperty("updateReturnDate"));
					statement.setInt(1, requestId);

					noOfRowsAffected = statement.executeUpdate();
					if (noOfRowsAffected != 0) {
						return true;
					} else {
						return false;
					}

				} else {
					throw new LibraryException("Invalid Return");
				}

			}

		} catch (Exception e) {
			throw new LibraryException("Invalid Return");
		} finally {
			try {

				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}// End Of Book Return
		// @SuppressWarnings("deprecation")

	@SuppressWarnings("resource")
	@Override
	public boolean isBookReceived(int requestId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int noOfDaysDelayed = 0;
		int fine = 0;
		int userId = 0;
		int boodId = 0;

		try (FileInputStream file = new FileInputStream("library.properties")) {
			Properties properties = new Properties();
			properties.load(file);

			Class.forName(properties.getProperty("driver"));
			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"))) {
				statement = connection.prepareStatement(properties.getProperty("receiveBook"));
				statement.setInt(1, requestId);
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					// Date issuedDate = resultSet.getDate("issuedDate");
					Date returnedDate = resultSet.getDate("returnedDate");
					Date expectedReturnedDate = resultSet.getDate("expectedReturnDate");
					userId = resultSet.getInt("userId");
					boodId = resultSet.getInt("bookId");

					if (returnedDate != null) {
						statement = connection.prepareStatement(properties.getProperty("getfine"));
						statement.setDate(1, returnedDate);
						statement.setDate(2, expectedReturnedDate);
						statement.setInt(3, requestId);

						resultSet = statement.executeQuery();

						while (resultSet.next()) {
							noOfDaysDelayed = resultSet.getInt(1);
						}
						if (noOfDaysDelayed > 0) {
							fine = noOfDaysDelayed * 5;
							statement = connection.prepareStatement(properties.getProperty("userFine"));
							statement.setInt(1, fine);
							statement.setInt(2, userId);

							noOfRowsAffected = statement.executeUpdate();
							if (noOfRowsAffected != 0) {
								System.out.println("fine updated" + fine);
							}

						}

						// Make available in libaray books
						statement = connection.prepareStatement(properties.getProperty("setBookAvailability2"));
						statement.setInt(1, boodId);
						noOfRowsAffected = statement.executeUpdate();

						// set No Of Books Borrowed
						statement = connection.prepareStatement(properties.getProperty("setNoOfBooksBorrowed2"));
						statement.setInt(1, userId);
						noOfRowsAffected = statement.executeUpdate();

						statement = connection.prepareStatement(properties.getProperty("removeRequest"));
						statement.setInt(1, requestId);

						noOfRowsAffected = statement.executeUpdate();

						return true;

					}

				} // End Of While Loop
				throw new LibraryException("Book Not Yet Returned");

			} // End of connection resource

		} catch (Exception e) {
			throw new LibraryException("Unable to Receive");
		} finally {
			try {

				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}// End Of Book Receive

}