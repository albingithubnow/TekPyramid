package dataDrivenTesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scenario1 {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\OneDrive\\Desktop\\New folder\\commondata.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String username  = p.getProperty("username");
		String password = p.getProperty("password");
		
		

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
		
		// click on create organization
		
		WebElement organization = driver.findElement(By.linkText("Organizations"));
		organization.click();
		
	WebElement addOrganization = driver.findElement(By.xpath("//img [@title ='Create Organization...']"));
	addOrganization.click();
		
		//enter all the details and create new organization
	
	driver.findElement(By.name("accountname")).sendKeys("FaceBook");
	driver.findElement(By.name("assigned_user_id")).click();
	driver.findElement(By.xpath("(//input [@title = 'Save [Alt+S]'])[1]")).click();
	
	
		//verify organization name in the header file
	
		// logout
		
	}
}
