package com.capgemini.librarymanagementsystemjdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookInfo;
import com.capgemini.librarymanagementsystemjdbc.dto.LibraryUsers;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestInfo;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryException;
import com.capgemini.librarymanagementsystemjdbc.utility.JdbcUtility;
import com.capgemini.librarymanagementsystemjdbc.utility.QueryMapper;

public class LibraryDAOImplementation implements LibraryDAO {
	int noOfRowsAffected;

	@Override
	public boolean register(LibraryUsers user) {

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement regUserStmt = connection.prepareStatement(QueryMapper.insertQuery)) {
			regUserStmt.setInt(1, user.getId());
			regUserStmt.setString(2, user.getName());
			regUserStmt.setString(3, user.getEmailId());
			regUserStmt.setString(4, user.getPassword());
			regUserStmt.setInt(5, user.getNoOfBooksBorrowed());
			regUserStmt.setString(6, user.getRole());
			regUserStmt.executeUpdate();

		} catch (Exception e) {
			throw new LibraryException("Cannot Register, As User Already Exists");
		}
		return true;
	}

	@Override
	public boolean adminAuthentication(int id, String password) {
		LibraryUsers users = new LibraryUsers();

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement statement = connection.prepareStatement(QueryMapper.adminLogin)) {
			statement.setInt(1, id);
			statement.setString(2, password);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					users.setId(resultSet.getInt("id"));
					users.setPassword(resultSet.getString("password"));
					users.setEmailId(resultSet.getString("emailId"));
					users.setName(resultSet.getString("name"));
					users.setRole(resultSet.getString("role"));
					users.setNoOfBooksBorrowed(resultSet.getInt("noOfBooksBorrowed"));
					return true;
				}
			}
		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		}
		throw new LibraryException("Invalid LogIn Credentials");
	}

	@Override
	public boolean userAuthentication(int id, String password) {
		LibraryUsers users = new LibraryUsers();

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement statement = connection.prepareStatement(QueryMapper.userLogin)) {
			statement.setInt(1, id);
			statement.setString(2, password);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					users.setId(resultSet.getInt("id"));
					users.setPassword(resultSet.getString("password"));
					users.setEmailId(resultSet.getString("emailId"));
					users.setName(resultSet.getString("name"));
					users.setRole(resultSet.getString("role"));
					users.setNoOfBooksBorrowed(resultSet.getInt("noOfBooksBorrowed"));
					return true;
				}
			}

		} catch (Exception e) {
			throw new LibraryException("SomeThing Went Wrong");
		}
		throw new LibraryException("Invalid LogIn Credentials");
	}

	@Override
	public boolean addBook(BookInfo book) {

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement statement = connection.prepareStatement(QueryMapper.insertBook);) {
			statement.setInt(1, book.getIsbn());
			statement.setString(2, book.getBookTitle());
			statement.setString(3, book.getAuthourName());
			statement.setDouble(4, book.getPrice());
			statement.setBoolean(5, book.isAvailable());
			statement.executeUpdate();

		} catch (Exception e) {
			throw new LibraryException("Cannot Add Book, As Book Id Already Exits");
		}
		return true;
	}

	@Override
	public boolean deleteBook(int isbn) {

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement statement = connection.prepareStatement(QueryMapper.deleteBook)) {

			statement.setInt(1, isbn);
			noOfRowsAffected = statement.executeUpdate();
			if (noOfRowsAffected != 0) {
				return true;
			} else {
				throw new LibraryException("Book Id Not Exists for Delete");
			}

		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		}
	}

	@Override
	public List<BookInfo> showBooks() {

		try (Connection connection = JdbcUtility.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QueryMapper.showBooks)) {
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

			if (list.isEmpty()) {
				throw new LibraryException("No Books Found In The Library");
			} else {
				return list;
			}

		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		}

	}

	@Override
	public List<BookInfo> searchBook(BookInfo bookInfo) {

		if (bookInfo.getIsbn() != 0) {

			try (Connection connection = JdbcUtility.getConnection();
					PreparedStatement statement = connection.prepareStatement(QueryMapper.searchBookById)) {
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

			} // End of Try Resources BookId Search
			catch (Exception e) {
				throw new LibraryException(e.getMessage());
			}
		} else if (bookInfo.getBookTitle() != null)

		{

			try (Connection connection = JdbcUtility.getConnection();
					PreparedStatement statement = connection.prepareStatement(QueryMapper.searchBookByTitle)) {
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
					if (list.isEmpty()) {
						throw new LibraryException("No Books Found With Given Name");
					}
					return list;

				} // End Of Try Resource Result Set
			} // End Of Try Resource Connection, Prepared Statement
			catch (Exception e) {
				throw new LibraryException(e.getMessage());
			}
		} else if (bookInfo.getAuthourName() != null)

		{

			try (Connection connection = JdbcUtility.getConnection();
					PreparedStatement statement = connection.prepareStatement(QueryMapper.searchBookByAuthour)) {
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
					if (list.isEmpty()) {
						throw new LibraryException("No Books Found With Given Authour");
					}
					return list;

				} // End Of Try Resource Result Set
			} // End Of Try Resource Connection, Prepared Statement
			catch (Exception e) {
				throw new LibraryException(e.getMessage());
			}
		} else {
			throw new LibraryException("Book Not Found ");
		}

	} // End Of Book Search

	@Override
	public List<LibraryUsers> showUsers() {

		try (Connection connection = JdbcUtility.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QueryMapper.showUsers)) {

			List<LibraryUsers> list = new LinkedList<LibraryUsers>();

			while (resultSet.next()) {
				LibraryUsers users = new LibraryUsers();

				users.setId(resultSet.getInt("id"));
				users.setName(resultSet.getString("name"));
				users.setEmailId(resultSet.getString("emailId"));
				users.setNoOfBooksBorrowed(resultSet.getInt("noOfBooksBorrowed"));
				users.setRole(resultSet.getString("role"));
				users.setFine(resultSet.getDouble("fine"));

				list.add(users);
			}

			if (list.isEmpty()) {
				throw new LibraryException("No User Found");
			} else {
				return list;
			}
		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		}
	}

	@Override
	public boolean bookRequest(int userId, int bookId) {
		boolean isavail = false;
		int reqestedBookId = 0;
		int validBookId = 0;
		int noOfRequests = 0;

		try (Connection connection = JdbcUtility.getConnection();
				Statement isReqExists = connection.createStatement();
				PreparedStatement countReqStmt = connection.prepareStatement(QueryMapper.countRequests);
				PreparedStatement statement = connection.prepareStatement(QueryMapper.checkAvailability);
				PreparedStatement statement1 = connection.prepareStatement(QueryMapper.insertBookRequest);) {

			try (ResultSet resultSet = isReqExists.executeQuery(QueryMapper.showRequests)) {
				while (resultSet.next()) {
					reqestedBookId = resultSet.getInt("bookId");
					if (reqestedBookId == bookId) {
						throw new LibraryException("Someone Has Already Placed This Book Request");
					}
				}

			}
			countReqStmt.setInt(1, userId);

			try (ResultSet countSet = countReqStmt.executeQuery()) {
				if (countSet.next()) {
					noOfRequests = countSet.getInt(1);
//						System.out.println("no of req already placed" + noOfRequests);
				}

				if (noOfRequests < 3) {
					statement.setInt(1, bookId);

					try (ResultSet isAvailSet = statement.executeQuery();) {
						while (isAvailSet.next()) {
							validBookId = isAvailSet.getInt("isbn");
							isavail = isAvailSet.getBoolean("isAvailable");
						}

						if (validBookId != 0) {
							if (isavail) {
								statement1.setInt(1, userId);
								statement1.setInt(2, bookId);
								statement1.executeUpdate();

								RequestInfo requestInfo = new RequestInfo();
								requestInfo.setUserId(userId);
								requestInfo.setBookId(bookId);

								return true;
							} else {
								throw new LibraryException("Book Is Not Available For Borrowing");
							}
						} else {
							throw new LibraryException("Invalid Book Id");
						}
					} // End Of ResultSet
				} else {
					throw new LibraryException("Can't Place More Than 3 Requests");
				}
			} // End Of Count ResultSet

			// End Of Try Resource Connection

		} catch (Exception e) {
//			e.printStackTrace();
			throw new LibraryException(e.getMessage());
		}

	}

	@Override
	public List<RequestInfo> showRequests() {

		try (Connection connection = JdbcUtility.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QueryMapper.showRequests)) {
			List<RequestInfo> list = new LinkedList<RequestInfo>();

			while (resultSet.next()) {
				RequestInfo requestInfo = new RequestInfo();

				requestInfo.setRequestId(resultSet.getInt("requestId"));
				requestInfo.setUserId(resultSet.getInt("userId"));
				requestInfo.setBookId(resultSet.getInt("bookId"));
				requestInfo.setIssuedDate(resultSet.getDate("issuedDate"));
				requestInfo.setExpectedReturnedDate(resultSet.getDate("expectedReturnDate"));
				requestInfo.setReturnedDate(resultSet.getDate("returnedDate"));

				list.add(requestInfo);
			}
			if (list.isEmpty()) {
				throw new LibraryException("No Requests Found");
			} else {
				return list;
			}

		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		}
	}

	@Override
	public boolean isBookIssued(int requestId) {

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement getReqStmt = connection.prepareStatement(QueryMapper.getRequest);
				PreparedStatement getUserStmt = connection.prepareStatement(QueryMapper.getUser);
				PreparedStatement issueStmt = connection.prepareStatement(QueryMapper.issueBook);
				PreparedStatement setBookAvailStmt = connection.prepareStatement(QueryMapper.setBookAvailability);
				PreparedStatement setBooksBorrowedStmt = connection
						.prepareStatement(QueryMapper.setNoOfBooksBorrowed);) {

			getReqStmt.setInt(1, requestId);
			try (ResultSet getReqResSet = getReqStmt.executeQuery();) {

				if (getReqResSet.next()) {
					int requestUserId = getReqResSet.getInt("userId");
					int requestBookId = getReqResSet.getInt("bookId");
					getUserStmt.setInt(1, requestUserId);

					try (ResultSet getUserResSet = getUserStmt.executeQuery();) {

						if (getUserResSet.next()) {
							LibraryUsers users = new LibraryUsers();
							users.setNoOfBooksBorrowed(getUserResSet.getInt("noOfBooksBorrowed"));
							int noOfBooksBorrowed = users.getNoOfBooksBorrowed();

							issueStmt.setInt(1, requestId);
							int updateDate = issueStmt.executeUpdate();
							if (updateDate != 0) {
								// Update book availability as false as we are issuing

								setBookAvailStmt.setInt(1, requestBookId);
								setBookAvailStmt.executeUpdate();

								// Update User no of books borrowed
								noOfBooksBorrowed++;

								setBooksBorrowedStmt.setInt(1, noOfBooksBorrowed);
								setBooksBorrowedStmt.setInt(2, requestUserId);
								setBooksBorrowedStmt.executeUpdate();

							} else {
								throw new LibraryException("This Book is Already Issued");
							}
						}
					} // End Of Gettinge User Result Set

				} else {
					throw new LibraryException("InValid Request Id ");
				}
			} // End Of Connection

		} catch (Exception e) {
			throw new LibraryException(e.getMessage());

		}
		return true;
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement getReqStmt = connection.prepareStatement(QueryMapper.getReqDetails);
				PreparedStatement updateDateStmt = connection.prepareStatement(QueryMapper.updateReturnDate);) {
			getReqStmt.setInt(1, userId);
			getReqStmt.setInt(2, bookId);

			try (ResultSet reqResSet = getReqStmt.executeQuery();) {
				if (reqResSet.next()) {
					int requestId = reqResSet.getInt("requestId");

					updateDateStmt.setInt(1, requestId);
					updateDateStmt.executeUpdate();

				} else {
					throw new LibraryException("Invalid Return");
				}

			}

		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		}
		return true;

	}// End Of Book Return

	@Override
	public boolean isBookReceived(int requestId) {
		int noOfDaysDelayed = 0;
		int fine = 0;
		int userId = 0;
		int boodId = 0;

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement getReqStmt = connection.prepareStatement(QueryMapper.getRequest);
				PreparedStatement fineStmt = connection.prepareStatement(QueryMapper.getfine);
				PreparedStatement setFineStmt = connection.prepareStatement(QueryMapper.userFine);
				PreparedStatement setBookAvailStmt = connection.prepareStatement(QueryMapper.setBookAvailability);
				PreparedStatement setNoOfBooksStmt = connection.prepareStatement(QueryMapper.setNoOfBooksBorrowed2);
				PreparedStatement removeReqStmt = connection.prepareStatement(QueryMapper.removeRequest);) {

			getReqStmt.setInt(1, requestId);
			try (ResultSet reqResSet = getReqStmt.executeQuery();) {
				while (reqResSet.next()) {
					Date returnedDate = reqResSet.getDate("returnedDate");
					Date expectedReturnedDate = reqResSet.getDate("expectedReturnDate");
					userId = reqResSet.getInt("userId");
					boodId = reqResSet.getInt("bookId");

					if (returnedDate != null) {
						fineStmt.setDate(1, returnedDate);
						fineStmt.setDate(2, expectedReturnedDate);
						fineStmt.setInt(3, requestId);

						try (ResultSet fineResSet = fineStmt.executeQuery();) {
							while (fineResSet.next()) {
								noOfDaysDelayed = fineResSet.getInt(1);
							}
						}

						if (noOfDaysDelayed > 0) {
							fine = noOfDaysDelayed * 5;

							setFineStmt.setInt(1, fine);
							setFineStmt.setInt(2, userId);
							setFineStmt.executeUpdate();
						}

						// Make available in libaray books
						setBookAvailStmt.setInt(1, boodId);
						setBookAvailStmt.executeUpdate();

						// set No Of Books Borrowed
						setNoOfBooksStmt.setInt(1, userId);
						setNoOfBooksStmt.executeUpdate();

						removeReqStmt.setInt(1, requestId);
						removeReqStmt.executeUpdate();

						return true;

					} else {
						throw new LibraryException("Book Not Yet Returned, So You Can't Receive");
					}
				} // End Of While Loop
			}
			throw new LibraryException("Invalid Request Id");
			// End of connection resource
		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		}

	}// End Of Book Receive

	@Override
	public boolean changePassword(int userId, String oldPassword, String newPassword) {

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement setPasswordSt = connection.prepareStatement(QueryMapper.setPassword)) {
			setPasswordSt.setString(1, newPassword);
			setPasswordSt.setString(2, oldPassword);
			setPasswordSt.setInt(3, userId);

			noOfRowsAffected = setPasswordSt.executeUpdate();
			if (noOfRowsAffected != 0) {
				return true;
			}

			throw new LibraryException("Invalid Credentials");
		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		}

	}
}
