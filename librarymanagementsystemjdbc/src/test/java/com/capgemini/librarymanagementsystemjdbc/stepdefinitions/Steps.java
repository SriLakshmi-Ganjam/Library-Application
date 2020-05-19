package com.capgemini.librarymanagementsystemjdbc.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.capgemini.librarymanagementsystemjdbc.dao.LibraryDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.LibraryDAOImplementation;
import com.capgemini.librarymanagementsystemjdbc.dto.LibraryUsers;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	private LibraryDAO dao = new LibraryDAOImplementation();
	LibraryUsers info;

	@Given("^User is on rgistration page$")
	public void user_is_on_rgistration_page() throws Throwable {
		info = new LibraryUsers();

	}

	@When("^User enters (\\d+), \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void user_enters(int arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		info.setId(arg1);
		info.setEmailId(arg2);
		info.setName(arg3);
		info.setPassword(arg4);
		info.setRole("Admin");
	}

	@Then("^User should be \"([^\"]*)\"$")
	public void user_should_be(String arg1) throws Throwable {
		boolean status = dao.register(info);
		Assertions.assertTrue(status);
	}

	@Given("^Admin is on login page$")
	public void admin_is_on_login_page() throws Throwable {
	}

	@When("^Admin gives \"([^\"]*)\", \"([^\"]*)\"$")
	public void admin_gives(String arg1, String arg2) throws Throwable {
	}

	@Then("^Admin should be logged in$")
	public void admin_should_be_logged_in() throws Throwable {
	}

	@When("^BooId and UserId are given (\\d+), (\\d+)$")
	public void booid_and_UserId_are_given(int arg1, int arg2) throws Throwable {
	}

	@Then("^Book Issued Successfully$")
	public void book_Issued_Successfully() throws Throwable {
	}

	@When("^BooId given (\\d+)$")
	public void booid_given(int arg1) throws Throwable {
	}

	@Then("^Book removed Successfully$")
	public void book_removed_Successfully() throws Throwable {
	}
}
