package TestCases;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import OtherPackage.GoBrowser;
import OtherPackage.PageDashboard;
import OtherPackage.PageForgotPassword;
import OtherPackage.PageLogin;
import OtherPackage.ReadConfigFile;

import org.junit.After;
import org.junit.Assert; 

public class UnitTesting {
	final String workingBrowser = "FF";
	final String configFile = "\\src\\UI Object Repository\\OR_Travels_Login.properties";
	final String configFileFP = "\\src\\UI Object Repository\\OR_Forgot_Password.properties";
	final String URL = "baseUrl";
	final String accURL = "accountUrl";
	final String forgotPswURL = "forgotPswUrl";
	final String requestPswURL = "requestPswUrl";
	String currentURL="";
	GoBrowser display;
	WebDriver displayBrowser;
	PageLogin login;
	PageDashboard vl;
	PageForgotPassword fp;
	ReadConfigFile readFile;
	@Before
	public void InitTest1 (){
		display = new GoBrowser();
		login = new PageLogin();
		vl = new PageDashboard();
		fp = new PageForgotPassword();
		readFile = new ReadConfigFile();
	}

	@Test
	public void LoginTestCase (){
		//Display the browser
		displayBrowser = display.Browser(workingBrowser,configFile,URL);
		//Get the current URL
		currentURL= displayBrowser.getCurrentUrl();
		//Validate that the current URL is the expected one
		Assert.assertEquals(currentURL, readFile.readFile(configFile, URL));
		//Login
		displayBrowser = login.Login(displayBrowser);	
		//Validate that the user is logged in
		Assert.assertEquals(true,vl.ValidationLogin(displayBrowser));
		//Validate the current URL is the expected one
		currentURL= displayBrowser.getCurrentUrl();
		Assert.assertEquals(currentURL, readFile.readFile(configFile, accURL));	
		//Logout
		displayBrowser=vl.Logout(displayBrowser);
		
	}
	@Test
	public void WrongPasswordTestCase (){
		//Display the browser
		displayBrowser = display.Browser(workingBrowser,configFile,URL);
		//Get the current URL
		currentURL= displayBrowser.getCurrentUrl();
		//Validate that the current URL is the expected one
		Assert.assertEquals(currentURL, readFile.readFile(configFile, URL));
		//Wrong Login
		displayBrowser=login.WrongPasswordLogin(displayBrowser);
		//Validate Wrong Password
		Assert.assertEquals(true,login.ValidateWrongPasswordLogin(displayBrowser));
		
	}
	
	@Test
	public void ForgotPasswordTestCase (){
		//Display the browser
		displayBrowser = display.Browser(workingBrowser,configFile,URL);
		//Get the current URL
		currentURL= displayBrowser.getCurrentUrl();
		//Validate that the current URL is the expected one
		Assert.assertEquals(currentURL, readFile.readFile(configFile, URL));
		//Select the link forgot password
		login.ForgotPasswordLogin(displayBrowser);
		//Get the current URL
		currentURL= displayBrowser.getCurrentUrl();
		//Validate that the current URL is the expected one
		Assert.assertEquals(currentURL, readFile.readFile(configFile, forgotPswURL));
		//Send a email
		displayBrowser=fp.SendEmail(displayBrowser);
		//Get the current URL
		currentURL= displayBrowser.getCurrentUrl();
		//Validate that the current URL is the expected one
		Assert.assertEquals(currentURL, readFile.readFile(configFileFP, requestPswURL));
		
	}
	@After
	public void CloseAnyBrowser (){
		//Close Browser
		displayBrowser.quit();
	}
}
