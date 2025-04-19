package com.groupexecution;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest  {	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("./TestData/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		Random random = new Random();
		int randomInt = random.nextInt(100);
		
		FileInputStream fis1 = new FileInputStream("./TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(1);
		String lastName = row.getCell(2).toString()+randomInt;
		wb.close();
		
		WebDriver driver = null;
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if 
			(browser.equals("edge")) {
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
			
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@title = \"Create Contact...\"]")).click();
		
		// enter data into create contact page
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		// verify the header phone number page
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actLastName.equals(lastName)) {
			System.out.println(lastName + " information verified");
		}else 
		{
			System.out.println(lastName + " information not verified");
		}}

	
}
