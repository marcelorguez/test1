package OtherPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLogin {
	private static final String configFile = "\\src\\UI Object Repository\\OR_Travels_Login.properties";
	private static final String txtBxUserName = "LoginPage.txtBxUserName";
	private static final String txtBxPassword = "LoginPage.txtBxPassword";
	private static final String btnSignIn = "LoginPage.btnLogin";
	private static final String txtErrorMsg = "LoginPage.txtErrorMsg";
	private static final String lnkForgotPassword = "LoginPage.lnkForgotPassword";
	private ReadConfigFile rf;
	private WebDriverWait wait;
	public WebDriver Login (WebDriver driver){
		rf = new ReadConfigFile();
		//Explicit Wait
		wait = new WebDriverWait(driver,30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(rf.readFile(configFile,txtBxUserName))));
		//Enter Username
		element = driver.findElement(By.id(rf.readFile(configFile,txtBxUserName)));
		element.sendKeys("marcelo_rguez_l_13@hotmail.com");
		//Enter Password
		element = driver.findElement(By.id(rf.readFile(configFile,txtBxPassword)));
		element.sendKeys("GeUg22mQ");
		//Click sign in button
		element = driver.findElement(By.id(rf.readFile(configFile,btnSignIn)));
		element.click();
		return driver;
	}
	public WebDriver WrongPasswordLogin (WebDriver driver){
		rf = new ReadConfigFile();
		//Explicit Wait
		wait = new WebDriverWait(driver,30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(rf.readFile(configFile,txtBxUserName))));
		//Enter Username
		element = driver.findElement(By.id(rf.readFile(configFile,txtBxUserName)));
		element.sendKeys("marcelo_rguez_l_13@hotmail.com");
		//Enter Password
		element = driver.findElement(By.id(rf.readFile(configFile,txtBxPassword)));
		element.sendKeys("xxxxxxxx");
		//Click sign in button
		element = driver.findElement(By.id(rf.readFile(configFile,btnSignIn)));
		element.click();
		return driver;
	}
	public Boolean ValidateWrongPasswordLogin (WebDriver driver){
		rf = new ReadConfigFile();
		//Explicit Wait
		wait = new WebDriverWait(driver,30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(rf.readFile(configFile,txtErrorMsg))));
		return element.isDisplayed();
	}
	public WebDriver ForgotPasswordLogin (WebDriver driver){
		rf = new ReadConfigFile();
		//Explicit Wait
		wait = new WebDriverWait(driver,30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(rf.readFile(configFile,lnkForgotPassword))));
		element.click();
		return driver;
	}
}
