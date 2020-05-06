package com.capgemini.librarymanagementsystemjdbc.utility;

public interface QueryMapper {

	String insertQuery = "insert into libraryusers (id,name,emailId,password,noOfBooksBorrowed,role) values(?,?,?,?,?,?)";

	String adminLogin = "select * from libraryusers where id = ? and password = ? and role = \"admin\"";

	String userLogin = "select * from libraryusers where id = ? and password = ?";

	String insertBook = "insert into librarybooks (isbn,bookTitle,authourName,price,isAvailable) values(?,?,?,?,?)";

	String deleteBook = "delete from librarybooks where isbn = ?";

	String showBooks = "select * from librarybooks";

	String showUsers = "select * from libraryusers";

	String showRequests = "select * from bookrequests";

	String countRequests = "select count(*) from bookrequests where userId = ?";

	String checkAvailability = "select * from librarybooks where isbn = ?";

	String insertBookRequest = "insert into bookrequests (userId,bookId) values(?,?)";

	String getRequest = "select * from bookrequests where requestId = ?";

	String getUser = "select * from libraryusers where id = ?";

	String issueBook = "update bookrequests set issuedDate = now(), expectedReturnDate = date_add(issuedDate, interval 15 day) where requestId = ? and issuedDate is null";

	String setBookAvailability = "update libraryBooks set isAvailable = false where isbn = ?";

	String setNoOfBooksBorrowed = "update libraryUsers set noOfBooksBorrowed = ? where id = ?";

	String deleteRequest = "delete from bookrequests where requestId = ?";

	String getReqDetails = "select * from bookrequests where (userId = ? and bookId = ?)  and (issuedDate  is not null and returnedDate is null)";

	String updateReturnDate = "update bookrequests set returneddate = '2020-05-30' where requestId = ?";

	String getfine = "select datediff(?,?) from bookrequests where requestId = ?";

	String userFine = "update libraryusers set fine = fine + ? where id = ?";

	String setBookAvailability2 = "update libraryBooks set isAvailable = true where isbn = ?";

	String setNoOfBooksBorrowed2 = "update libraryUsers set noOfBooksBorrowed =  noOfBooksBorrowed -1 where id = ?";

	String removeRequest = "delete from  bookrequests  where requestId = ?";

	String searchBookById = "select * from librarybooks where isbn = ?";

	String searchBookByTitle = "select * from librarybooks where bookTitle = ?";

	String searchBookByAuthour = "select * from librarybooks where authourName = ?";

	String setPassword = "update libraryUsers set password = ? where password = ? and id = ?";

}
