package com.capgemini.libraryspringrest.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = "D:\\LibraryManagementSystem\\libraryspringrest\\src\\test\\java\\com\\capgemini\\libraryspringrest\\features", 
						glue = {"com/capgemini/libraryspringrest/stepdefinitions" }, 
						dryRun = false,  
						plugin = { "pretty", "html:target/cucumber" }, 
						monochrome = true)
	public class TestRunner {

	}

