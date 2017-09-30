package OtherPackage;

import org.openqa.selenium.support.ui.Select;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageDashboard {
	private static final String configFile = "\\src\\UI Object Repository\\OR_Travels_Dashboard.properties";
	private static final String IIcon = "DashboardPage.IIcon";
	private ReadConfigFile rf;
	private WebDriverWait wait;
	private static final String dropBxUserName = "DashboardPage.dropBxUserName";
	private static final String lnkLogout="DashboardPage.lnkLogout";
	WebElement element;
	Select dropDown;
	public Boolean ValidationLogin (WebDriver driver){
		rf = new ReadConfigFile();
		//Explicit Wait
		wait = new WebDriverWait(driver,30);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(rf.readFile(configFile,IIcon))));
		return element.isDisplayed();
	}
	public WebDriver Logout (WebDriver driver){
		element = driver.findElement(By.id(rf.readFile(configFile,dropBxUserName))); 
		element.click();
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rf.readFile(configFile,lnkLogout))));
		element = driver.findElement(By.xpath(rf.readFile(configFile,lnkLogout))); 
		element.click();
		return driver;
	}
}
