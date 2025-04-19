package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrgWithJsonData {


	@Test
	public void createOrg() throws Throwable {
		
		
	
		//read common data from json 
		
		JSONParser parser = new JSONParser();
Object obj =  parser.parse(new FileReader("./TestData/appCommonData.json"));
		
		//Sep 2 : Convert java object into json object using downcasting
		
		JSONObject map = (JSONObject)obj;
		
		// step 3: get the value from json file using key
		String URL = (String) map.get("url");
		String BROWSER = (String) map.get("browser");
		String USERNAME = (String) map.get("username");
		String PASSWORD = (String) map.get("password");
		
		
		//generate random integer
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		
		
		FileInputStream fis1 = new FileInputStream("./TestData/testscriptdata.xlsx");
		
		//step 2: open workbook in read mode
		Workbook wb = WorkbookFactory.create(fis1);

		//step 3: get the control of the org sheet
		  Sheet sh = wb.getSheet("org");
		
		//step 4: get the control of the row
		  Row row = sh.getRow(1);
		  
		  String orgName = row.getCell(2).toString()+randomInt;
		 
		  
		wb.close();
		
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
			}
		else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		//Step 1 : open the application
		
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//step 2 : navigate to organization
				WebElement organization = driver.findElement(By.linkText("Organizations"));
				organization.click();
				
				// step 2: create organization button
				
				WebElement addOrganization = driver.findElement(By.xpath("//img [@title ='Create Organization...']"));
				addOrganization.click();
				

				//step 3:  enter all the details and create new organization
			
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.name("assigned_user_id")).click();
			driver.findElement(By.xpath("(//input [@title = 'Save [Alt+S]'])[1]")).click();
			
			// step 4: logout from application
			Actions act = new Actions(driver);

			act.moveToElement(driver.findElement(By.xpath("//img [@src = 'themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			
			driver.quit();
			
			System.out.println("Execution successfully completed");
			
			}

		
	}
///
