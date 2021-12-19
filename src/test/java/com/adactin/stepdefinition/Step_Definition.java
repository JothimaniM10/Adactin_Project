package com.adactin.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.adactin.baseclass.Base_Class;
import com.adactin.runner.Runner;

import cucumber.api.java.en.*;

public class Step_Definition extends Base_Class {

	public static WebDriver driver = Runner.driver;
	
	
	@Given("^User launch the adactin application$")
	public void user_launch_the_adactin_application() throws Throwable {
	}

	@When("^User enter the valid username$")
	public void user_enter_the_valid_username() throws Throwable {
	}

	@When("^User enter the valid password$")
	public void user_enter_the_valid_password() throws Throwable {
	}

	@Then("^User validating the username and password$")
	public void user_validating_the_username_and_password() throws Throwable {
	}


}
