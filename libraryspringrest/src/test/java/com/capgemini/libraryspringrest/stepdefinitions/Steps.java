package com.capgemini.libraryspringrest.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.capgemini.libraryspringrest.dao.LibraryDAO;
import com.capgemini.libraryspringrest.dao.LibraryDAOImplementation;
import com.capgemini.libraryspringrest.dto.LibraryUsers;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	private LibraryDAO dao = new LibraryDAOImplementation();
	LibraryUsers info;
	boolean status;

	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {	}

	@When("^User gives \"([^\"]*)\", \"([^\"]*)\"$")
	public void user_gives(String arg1, String arg2) throws Throwable {		
		status = dao.adminAuthentication(arg1, arg2);
	}

	@Then("^User should be logged in$")
	public void user_should_be_logged_in() throws Throwable {
		Assertions.assertTrue(status);
	}

	@Given("^Admin is on Registartion page$")
	public void admin_is_on_Registartion_page() throws Throwable {
		info = new LibraryUsers();
	  
	}

	@When("^Admin gives User Details (\\d+), \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void admin_gives_User_Details(int arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		info.setId(arg1);
		info.setEmailId(arg2);
		info.setName(arg3);
		info.setPassword(arg4);
		info.setRole(arg5);
		status = dao.register(info);
	   
	}

	@Then("^User Registered Successfully$")
	public void user_Registered_Successfully() throws Throwable {
		
		Assertions.assertTrue(status);	    
	}

}
