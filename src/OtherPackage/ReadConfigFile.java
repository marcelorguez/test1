package OtherPackage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {
	File file; 
	FileInputStream fileInput;
	
	public String readFile(String fileName,String var){
		String val="";
		try{
			file = new File(System.getProperty("user.dir") + fileName);
			fileInput= new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			val = properties.getProperty(var);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}
}
