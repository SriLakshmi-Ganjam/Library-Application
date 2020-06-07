package com.capgemini.libraryspringrest.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.capgemini.libraryspringrest.dao.LibraryDAO;
import com.capgemini.libraryspringrest.dao.LibraryDAOImplementation;
import com.capgemini.libraryspringrest.dto.LibraryUsers;
import com.capgemini.libraryspringrest.dto.RequestInfo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserSteps {
	private LibraryDAO dao = new LibraryDAOImplementation();
	boolean status;
	RequestInfo requestInfo;
	LibraryUsers users;

@Given("^User is on login page$")
public void user_is_on_login_page() throws Throwable {
   users = new LibraryUsers();
}

@When("^User gives \"([^\"]*)\", \"([^\"]*)\"$")
public void user_gives(String arg1, String arg2) throws Throwable {
	status = dao.adminAuthentication(arg1, arg2);
 
}

@Then("^User should be logged in$")
public void user_should_be_logged_in() throws Throwable {
	Assertions.assertTrue(status);
}

@Given("^User is on Request page$")
public void user_is_on_Request_page() throws Throwable {
	requestInfo = new RequestInfo();
}

@When("^User Requests a Book by valid User Id and Book Id (\\d+), (\\d+)$")
public void user_Requests_a_Book_by_valid_User_Id_and_Book_Id(int arg1, int arg2) throws Throwable {
	 status = dao.bookRequest(arg1, arg2);
	
    
}

@Then("^User Placed a Request Successfully$")
public void user_Placed_a_Request_Successfully() throws Throwable {
	Assertions.assertTrue(status);
}

@Given("^User is on Return page$")
public void user_is_on_Return_page() throws Throwable {
	requestInfo = new RequestInfo();
}


@When("^User Returns a Book by valid User Id and Book Id (\\d+), (\\d+)$")
public void user_Returns_a_Book_by_valid_User_Id_and_Book_Id(int arg1, int arg2) throws Throwable {
    status = dao.bookReturn(arg1, arg2);
}


@Then("^User  Returned the Book Successfully$")
public void user_Returned_the_Book_Successfully() throws Throwable {
	Assertions.assertTrue(status);
}



}
