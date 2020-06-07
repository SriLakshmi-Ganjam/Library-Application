package com.capgemini.lmsbdd.testrunner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\lmsbdd\\lmsbdd\\src\\main\\java\\com\\capgemini\\lmsbdd\\features", glue = {
		"com.capgemini.lmsbdd.stepdefinitions" }, dryRun = false, plugin = { "pretty",
				"html:target/cucumber" }, monochrome = true, tags = { "@register" })

public class TestRunner {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions action;

	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
}
