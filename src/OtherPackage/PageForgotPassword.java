package OtherPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageForgotPassword {
	private static final String configFile = "\\src\\UI Object Repository\\OR_Forgot_Password.properties";
	private static final String txtBoxRequestUN = "ForgotPasswordPage.txtBoxrequestuserName";
	private static final String email="ForgotPasswordPage.eMail";
	private static final String btnSubmit="ForgotPasswordPage.btnSubmit";
	private ReadConfigFile rf;
	private WebDriverWait wait;
	WebElement element;
	public WebDriver SendEmail (WebDriver driver){
		rf = new ReadConfigFile();
		//Explicit Wait
		wait = new WebDriverWait(driver,30);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(rf.readFile(configFile,txtBoxRequestUN))));
		element.sendKeys(rf.readFile(configFile,email));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(rf.readFile(configFile,btnSubmit))));
		element.click();
		return driver;
	}
}
