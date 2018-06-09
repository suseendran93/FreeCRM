package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage; // object reference of login page
	HomePage homePage;	//Object reference of Homepage . This is needed as login page lands in Homepage
	
	public LoginPageTest() { // Constructor of this class(LoginPageTest)
		super(); // Constructor of super or parent class(TestBase)
	}

	@BeforeMethod

	public void setup() {
		intialization();//Method of parent class
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)//import from TestNG 
	
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
		//You can even use if else but Assert is from TestNG so, better use that
	}
	
	@Test(priority=2)
	
	public void crmLogoTest() {
		
		boolean bool=loginPage.validateCRMImage();
		Assert.assertTrue(bool);
	}
	
	@Test(priority=3)
	
	public void loginTest() throws InterruptedException {
		homePage=loginPage.login(prop.getProperty("username"),
									prop.getProperty("password"));//From config.properties
	}
	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}

}
