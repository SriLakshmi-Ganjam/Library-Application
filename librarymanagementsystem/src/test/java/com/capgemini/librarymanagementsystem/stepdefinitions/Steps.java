package com.capgemini.librarymanagementsystem.stepdefinitions;



import static org.junit.jupiter.api.Assertions.assertTrue;

import com.capgemini.librarymanagementsystem.dao.LibraryDAO;
import com.capgemini.librarymanagementsystem.dao.LibraryDAOImplementation;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	private LibraryDAO dao = new LibraryDAOImplementation();
	static UserInfo info;
	
	@Given("^User is on registration page$")
	public void user_is_on_registration_page() throws Throwable {
		info = new UserInfo();
	}

	@When("^User gave (\\d+) , \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void user_gave(int arg1, String arg2, String arg3, String arg4) throws Throwable {
		info.setUserId(arg1);
		info.setUserEmailId(arg2);
		info.setUserName(arg3);
		info.setUserPassword(arg4);
		
	}

	@Then("^User should be \"([^\"]*)\"$")
	public void user_should_be(String arg1) throws Throwable {
		boolean status = dao.register(info);
		assertTrue(status);
	}



}
