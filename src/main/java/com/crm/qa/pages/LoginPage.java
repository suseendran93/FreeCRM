package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory or Object Repo

	@FindBy(name = "username") // Similar to driver.FindElementBy.name
	WebElement username;		//stores xpath in username

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//button[contains(text(),Sign up)]")
	WebElement signUpButton;

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement freeCrmlogo;

	// Initializing the page objects
	public LoginPage() {

		PageFactory.initElements(driver, this);//Initialize all above objects of this (login) page
	}

	// Actions or Features or Methods
	public String validateLoginPageTitle() {

		return driver.getTitle();

	}

	public boolean validateCRMImage() {
		return freeCrmlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginButton.click();
		//After login it will land on homepage ,so it should return object of homepage
		
		return new HomePage();
	}
}
