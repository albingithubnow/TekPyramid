package dataDrivenTesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrg {

	public static void main(String[] args) throws Exception {
		
		
		//step 1:  get the java representation object of the physical file
		
		// to obtain the path right click on the file and and select properties and go to securities and copy he path
		FileInputStream fis = new FileInputStream("./TestData/commondata.properties");
		
		//step 2:  using property class load all the key
		Properties pobj = new Properties();
		pobj.load(fis);
		
		//step 3:  get value based on  key
		String browser = pobj.getProperty("browser");
		
//		System.out.println(browser);
		
		String url = pobj.getProperty("url");
//		System.out.println(url);
		
		String username = pobj.getProperty("username");
//		System.out.println(username);
		
		String password = pobj.getProperty("password");
		System.out.println(password);
		
		
//		Scanner s = new Scanner(System.in);
//		System.out.println("Browser");
//		String browsers = s.next();
//		
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equals("edge")) {
			driver=  new EdgeDriver();
		}
		else
			driver = new ChromeDriver();
		
	
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
//		driver.findElement(By.linkText("Organizaion")).click();
		driver.quit();
	
		
	}
}
