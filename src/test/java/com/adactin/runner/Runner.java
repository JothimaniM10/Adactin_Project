package com.adactin.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.adactin.baseclass.Base_Class;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\adactin\\feature",
glue = "com//adactin//stepdefinition")
public class Runner {

	public static WebDriver driver;
	
	@BeforeClass
	public static void launchBrowser() {
driver = Base_Class.get_Driver("chrome");

Base_Class.get("https://adactinhotelapp.com/");
	}
	
}
