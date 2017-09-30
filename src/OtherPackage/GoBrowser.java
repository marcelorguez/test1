package OtherPackage;
import org.openqa.selenium.WebDriver;

public class GoBrowser {
	public WebDriver Browser(String browser,String fn, String col){
		ReadConfigFile rf = new ReadConfigFile();
		String URL = rf.readFile(fn,col);
		WebDriver display = null;
		Go dis = null;
		if (browser=="FF"){
			dis = new GoFirefox();
		}else if (browser=="C"){
			dis = new GoChrome();
		}else if (browser=="IE"){
			dis = new GoIExplorer();
		}
		display = dis.Open();
		display.get(URL);
		display.manage().window().maximize();
		return display;
	}
}
