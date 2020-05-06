package com.capgemini.libraryspringrest.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.libraryspringrest.dto.BookInfo;
import com.capgemini.libraryspringrest.dto.LibraryUsers;
import com.capgemini.libraryspringrest.dto.RequestInfo;
import com.capgemini.libraryspringrest.exception.LibraryException;

public class LibraryDAOImplementation implements LibraryDAO {

	@Override
	public boolean register(LibraryUsers user) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			transaction.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw new LibraryException("User Already Exists");
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public boolean adminAuthentication(int id, String password) {
		LibraryUsers users = new LibraryUsers();
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			transaction.begin();
			users = manager.find(LibraryUsers.class, id);

			if (users.getPassword().equals(password) && users.getRole().equalsIgnoreCase("admin")) {
				transaction.commit();
				return true;
			} else {
				throw new LibraryException("Invalid password");
			}

		} catch (Exception e) {
			transaction.rollback();
			throw new LibraryException("Invalid  Credentials");
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public boolean userAuthentication(int id, String password) {
		LibraryUsers users = new LibraryUsers();
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			transaction.begin();
			users = manager.find(LibraryUsers.class, id);

			if (users.getPassword().equals(password) && users.getRole().equalsIgnoreCase("user")) {
				transaction.commit();
				return true;
			} else {
				throw new LibraryException("Invalid password");
			}

		} catch (Exception e) {
			transaction.rollback();
			throw new LibraryException("Invalid  Credentials");
		}
	}

	@Override
	public boolean addBook(BookInfo book) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(book);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new LibraryException("Book Already Exists");
		} finally {
			manager.close();
			factory.close();
		}

	}

	@Override
	public boolean deleteBook(int isbn) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		BookInfo info = new BookInfo();
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			info = manager.find(BookInfo.class, isbn);
			manager.remove(info);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new LibraryException("No Book Found With Given Id");
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<BookInfo> showBooks() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select books from BookInfo books";
			TypedQuery<BookInfo> query = manager.createQuery(jpql, BookInfo.class);
			List<BookInfo> list = query.getResultList();

			if (list.isEmpty()) {
				throw new LibraryException("No Books Found");
			} else {
				return list;
			}

		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}

	}

	@Override
	public List<LibraryUsers> showUsers() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select users from LibraryUsers users";
			TypedQuery<LibraryUsers> query = manager.createQuery(jpql, LibraryUsers.class);
			List<LibraryUsers> list = query.getResultList();

			if (list.isEmpty()) {
				throw new LibraryException("No Users Found");
			} else {
				return list;
			}

		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}

	}

	@Override
	public List<BookInfo> searchBook(BookInfo bookInfo) {
		EntityManager manager = null;
		EntityManagerFactory factory = null;

		BookInfo info = new BookInfo();
		List<BookInfo> list = new LinkedList<BookInfo>();

		String jpql = null;
		int id = bookInfo.getIsbn();
		String bookName = bookInfo.getBookTitle();
		String authourName = bookInfo.getAuthourName();

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			if (id != 0) {
				info = manager.find(BookInfo.class, id);
				if (info != null) {
					System.out.println("book id found is" + info.getIsbn());
					list.add(info);
					return list;
				} else {
					throw new LibraryException("Book Id Not found");
				}

			} else if (bookName != null) {

				jpql = "select books from BookInfo books where books.bookTitle =:bookTitle ";
				TypedQuery<BookInfo> query = manager.createQuery(jpql, BookInfo.class);
				query.setParameter("bookTitle", bookName);
				list = query.getResultList();
				if (list != null) {
					return list;
				} else {
					throw new LibraryException("Book Name Not found");
				}

			} else if (authourName != null) {
				jpql = "select books from BookInfo books where books.authourName = :aName";
				TypedQuery<BookInfo> query = manager.createQuery(jpql, BookInfo.class);
				query.setParameter("aName", authourName);
				list = query.getResultList();
				if (list != null) {
					return list;
				} else {
					throw new LibraryException("Book authour name not found");
				}
			} else {
				throw new LibraryException("Exception caught in searching");
				// return null;
			}
		} catch (LibraryException e) {
//			e.printStackTrace();
			System.out.println("Error caught in impl");
			throw new LibraryException("Exception caught in searching");

		} finally {
			manager.close();
			factory.close();
		}

	}

	@Override
	public List<RequestInfo> showRequests() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select reqs from RequestInfo reqs";
			TypedQuery<RequestInfo> query = manager.createQuery(jpql, RequestInfo.class);
			List<RequestInfo> list = query.getResultList();
			if (list.isEmpty()) {
				throw new LibraryException("No Requests Found");
			} else {
				return list;
			}

		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}

	}

	@Override
	public boolean bookRequest(int userId, int bookId) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		RequestInfo info = new RequestInfo();
		BookInfo bookInfo = new BookInfo();

		String jpql = null;
		int noOfReq = 0;

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			jpql = "select count(*) from RequestInfo ri where ri.userId=:uId";
			Query query = manager.createQuery(jpql);
			query.setParameter("uId", userId);
			noOfReq = ((Number) query.getSingleResult()).intValue();
			System.out.println("no of req placed" + noOfReq);

			if (noOfReq < 3) {
				bookInfo = manager.find(BookInfo.class, bookId);

				if (bookInfo != null) {
					jpql = "select ri from RequestInfo ri ";
					TypedQuery<RequestInfo> query2 = manager.createQuery(jpql, RequestInfo.class);
					List<RequestInfo> list = query2.getResultList();

					for (RequestInfo requestInfo : list) {
						if (requestInfo.getBookId() == bookId) {
							throw new LibraryException("This Book Request is Already Placed By SomeOne ");
						}
					}

					if (bookInfo.isAvailable()) {
						System.out.println("tans started");
						transaction.begin();
						info.setUserId(userId);
						info.setBookId(bookId);
						manager.persist(info);
						transaction.commit();
					} else {
						throw new LibraryException("This Book Is Not Available For Borrowing");
					}

				} else {
					throw new LibraryException("Invalid Book Id");
				}

			} else {
				throw new LibraryException("You 've Already Placed Maximum No Of Requests");
			}

		} catch (LibraryException e) {
			transaction.rollback();
			throw new LibraryException(e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}
		return true;
	}

	@Override
	public boolean isBookIssued(int requestId) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		RequestInfo info = new RequestInfo();
		BookInfo bookInfo = new BookInfo();
		LibraryUsers user = new LibraryUsers();

		int noOfBooks = 0;
		int reqBookId = 0;
		int reqUserId = 0;

		Date date = new Date();
		Date expectedReturnDate = null;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 15);
		expectedReturnDate = calendar.getTime();

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			transaction.begin();
			info = manager.find(RequestInfo.class, requestId);

			if (info != null) {
				Date issueDate = info.getIssuedDate();
				if (issueDate == null) {
					reqUserId = info.getUserId();
					reqBookId = info.getBookId();

					info.setIssuedDate(date);
					info.setExpectedReturnDate(expectedReturnDate);
					transaction.commit();

					transaction.begin();
					user = manager.find(LibraryUsers.class, reqUserId);
					noOfBooks = user.getNoOfBooksBorrowed();
					++noOfBooks;
					System.out.println("No Of Books Borrowed" + noOfBooks);

					user.setNoOfBooksBorrowed(noOfBooks);
					transaction.commit();

					transaction.begin();
					bookInfo = manager.find(BookInfo.class, reqBookId);
					bookInfo.setAvailable(false);
					transaction.commit();
				} else {
					throw new LibraryException("This Book Is Already Issued");
				}

			} else {
				throw new LibraryException("Invalid Request Id");
			}

		} catch (Exception e) {
			transaction.rollback();
			throw new LibraryException(e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}
		return false;
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		RequestInfo info = new RequestInfo();

		String jpql = null;
		int reqId = 0;

		Calendar calendar2 = Calendar.getInstance();
		calendar2.add(Calendar.DATE, 20);
		Date returnedDate = calendar2.getTime();

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			jpql = "select ri from RequestInfo ri ";
			TypedQuery<RequestInfo> query2 = manager.createQuery(jpql, RequestInfo.class);
			List<RequestInfo> list = query2.getResultList();

			for (RequestInfo requestInfo : list) {
				if ((requestInfo.getBookId() == bookId) && (requestInfo.getUserId() == userId)) {
					if (requestInfo.getReturnedDate() != null) {
						throw new LibraryException("You Have Already Returned This Book");

					} else {
						reqId = requestInfo.getRequestId();
					}

				}
			}

			if (reqId != 0) {
				transaction.begin();
				info = manager.find(RequestInfo.class, reqId);
				info.setReturnedDate(returnedDate);
				transaction.commit();

			} else {
				throw new LibraryException("Invalid Book Id,This Is Not The Book You Have Taken / Book Not Yet Issued");
			}

		} catch (LibraryException e) {
			throw new LibraryException(e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}

		return true;
	}

	@Override
	public boolean isBookReceived(int requestId) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		RequestInfo info = new RequestInfo();
		BookInfo bookInfo = new BookInfo();
		LibraryUsers user = new LibraryUsers();

		int noOfBooks = 0;
		int reqBookId = 0;
		int reqUserId = 0;
		double fine = 0;

		Date expectedReturnDate = null;
		Date returnedDate = null;

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			transaction.begin();
			info = manager.find(RequestInfo.class, requestId);

			if (info != null) {
				reqBookId = info.getBookId();
				reqUserId = info.getUserId();
				returnedDate = info.getReturnedDate();
				expectedReturnDate = info.getExpectedReturnDate();
				transaction.commit();

				if ((returnedDate != null) && (expectedReturnDate != null)) {
					long expReturnDateInMilliSecs = expectedReturnDate.getTime();
					long returnedDateInMilliSecs = returnedDate.getTime();
					long diffInMilliSecs = returnedDateInMilliSecs - expReturnDateInMilliSecs;
					int NoOfDaysDelayed = (int) (diffInMilliSecs / (24 * 60 * 60 * 1000));

					transaction.begin();
					user = manager.find(LibraryUsers.class, reqUserId);
					noOfBooks = user.getNoOfBooksBorrowed();
					--noOfBooks;
					user.setNoOfBooksBorrowed(noOfBooks);
					if (NoOfDaysDelayed > 0) {
						fine = user.getFine();
						fine = fine + (NoOfDaysDelayed * 5);
						user.setFine(fine);
					}
					transaction.commit();

					transaction.begin();
					bookInfo = manager.find(BookInfo.class, reqBookId);
					bookInfo.setAvailable(true);
					transaction.commit();

					transaction.begin();
					info = manager.find(RequestInfo.class, requestId);
					manager.remove(info);
					transaction.commit();

				} else {
					throw new LibraryException("User Not Yet Returned The Book");
				}

			} else {
				throw new LibraryException("Invalid Request Id");
			}
		} catch (LibraryException e) {
//			transaction.rollback();
			e.printStackTrace();
			throw new LibraryException(e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}
		return true;
	}

	@Override
	public boolean changePassword(int userId, String oldPassword, String newPassword) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		LibraryUsers user = new LibraryUsers();
		String password = null;

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			transaction.begin();
			user = manager.find(LibraryUsers.class, userId);
			password = user.getPassword();
			if (password.equals(oldPassword)) {
				user.setPassword(newPassword);
				transaction.commit();
			} else {
				throw new LibraryException("Invalid Password");
			}
		} catch (LibraryException e) {
			throw new LibraryException(e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}
		return true;
	}

}