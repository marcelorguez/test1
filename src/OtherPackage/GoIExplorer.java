package OtherPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GoIExplorer implements Go{
	public WebDriver Open (){
		System.setProperty(DriverIExplorer,FileIExplorer);
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		return new InternetExplorerDriver(capabilities); 
	}
}
