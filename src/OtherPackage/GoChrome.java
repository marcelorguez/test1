package OtherPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoChrome implements Go{
	public WebDriver Open (){
		System.setProperty(DriverChrome,FileChrome);
		return new ChromeDriver();
	}
}
