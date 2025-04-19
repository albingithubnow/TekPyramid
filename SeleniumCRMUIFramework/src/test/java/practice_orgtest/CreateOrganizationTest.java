package practice_orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Exception {
		
		//read data from property file
		FileInputStream fis = new FileInputStream("./TestData/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		
		FileInputStream fis1 = new FileInputStream(".\\TestData\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString() + randomInt;
		wb.close();
		
		WebDriver driver = null;
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();			
		}
		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
	//Step 1 : open the application
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//step 2 : navigate to organization
		WebElement organization = driver.findElement(By.linkText("Organizations"));
		organization.click();
		
		// step : create organization button
		
		WebElement addOrganization = driver.findElement(By.xpath("//img [@title ='Create Organization...']"));
		addOrganization.click();
		

		//step 3:  enter all the details and create new organization
	
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.name("assigned_user_id")).click();
	driver.findElement(By.xpath("(//input [@title = 'Save [Alt+S]'])[1]")).click();
	
	//verify header message expected result
	
	String headerInfo = driver.findElement(By.xpath("//span[@class = 'dvHeaderText']")).getText();
	if(headerInfo.contains(orgName)) {
		System.out.println(orgName + " displayed in organization Info page ----- PASS");
	}else {
		System.out.println(orgName + " is not displayed in organization Info Page ----- FAIL");
	}
	
	//verify header orgname info expected result : EXPECTED RESULT
	
	String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
	if(actualOrgName.contains(orgName)) {
		System.out.println("Organization name verified ----- PASS");
	}else
	{
		System.out.println("organization name not verified ----- FAIL");
	}
	
	
	
// step 4: logout from application
	Actions act = new Actions(driver);

	act.moveToElement(driver.findElement(By.xpath("//img [@src = 'themes/softed/images/user.PNG']"))).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	
	driver.quit();
	
	System.out.println("Execution successfully completed");
	
	}
}
