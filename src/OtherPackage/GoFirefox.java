package OtherPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class GoFirefox implements Go{
	public WebDriver Open(){
		System.setProperty(DriverFireFox,FileFirefox);
		return new FirefoxDriver();
	}
}
//This is a comment 1
