package com.pac3.BaseClassCreation;

import java.sql.SQLException;

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
import org.testng.annotations.Parameters;

import com.crm.vtiger.objectrepositoryutility.HomePage;
import com.crm.vtiger.objectrepositoryutility.LoginPage;
import com.seleniumcrm.generic.dbutility.DataBaseUtility;
import com.seleniumcrm.generic.fileutility.ExcelUtility;
import com.seleniumcrm.generic.fileutility.FileUtility;
import com.seleniumcrm.generic.webdriverutility.JavaUtility;
import com.seleniumcrm.generic.webdriverutility.WebDriverUtility;


public class BaseClass {

	public ExcelUtility eLib = new ExcelUtility();
	public DataBaseUtility dbLib = new DataBaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public static WebDriver driver = null;// should be declared globally, because it is also required before method to log into application
	// if declared locally if cannot be accessed

	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("connect to DataBase and report Config");
		dbLib.getDbconnection();
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
		System.out.println("Launch the Browser");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
	
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if 
			(BROWSER.equals("edge")) {
				driver = new EdgeDriver();			
		}
		else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
					}
	}
	

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configMethod() throws Throwable {
		System.out.println("Login to application");
		LoginPage lp = new LoginPage(driver);
		
		String url = fLib.getDataFromPropertiesFile("url");
		String username= fLib.getDataFromPropertiesFile("username");
		String password = fLib.getDataFromPropertiesFile("password");
		
		lp.loginToApp(url,username, password);
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAfterMethod() {
		System.out.println("Logout from application");
		HomePage hp = new HomePage(driver);
		hp.logOut();
	}
	
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC()  {
		System.out.println("Close the browser");
		driver.quit();
	}

	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAF() throws SQLException {
		System.out.println("close DataBase and Report Backup");
		dbLib.closeDBConnection();
	}
	
	
}
