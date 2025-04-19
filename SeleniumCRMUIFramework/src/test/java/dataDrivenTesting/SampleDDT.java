package dataDrivenTesting;

import java.io.FileInputStream;
import java.util.Properties;

public class SampleDDT {

	public static void main(String[] args) throws Exception {
		
		//step 1:  get the java representation object of the physical file
		
		// to obtain the path right click on the file and and select properties and go to securities and copy he path
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\OneDrive\\Desktop\\commondata.properties");
		
		//step 2:  using property class load all the key
		Properties pobj = new Properties();
		pobj.load(fis);
		
		
		//step 3:  get value based on  key
		String browser = pobj.getProperty("browser");
		System.out.println(browser);
		
		String url = pobj.getProperty("url");
		System.out.println(url);
	}
	
}
