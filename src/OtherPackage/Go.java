package OtherPackage;
import org.openqa.selenium.WebDriver;

public interface Go {
	public static final String FileFirefox = "C:\\Users\\marcelo rodriguez\\Documents\\Vixxo\\Automation\\browsers\\geckodriver-v0.18.0-win32\\geckodriver.exe";
	public static final String FileChrome = "C:\\Users\\marcelo rodriguez\\Documents\\Vixxo\\Automation\\browsers\\chromedriver_win32\\chromedriver.exe";
	public static final String FileIExplorer = "C:\\Users\\marcelo rodriguez\\Documents\\Vixxo\\Automation\\browsers\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe";
	public static final String DriverFireFox = "webdriver.gecko.driver";
	public static final String DriverChrome = "webdriver.chrome.driver";
	public static final String DriverIExplorer = "webdriver.ie.driver";
	WebDriver Open ();
}
