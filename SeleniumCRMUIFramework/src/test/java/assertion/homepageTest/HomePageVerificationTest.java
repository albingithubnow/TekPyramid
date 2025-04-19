package assertion.homepageTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest {

	@Test
	public void homePageTest(Method mtd) {
		
		System.out.println(mtd.getName() + "Test sarts");
		
		String expectedPage = "Home page";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("Albin@123");
		driver.findElement(By.id("submitButton")).click();
		
		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
		// HARD ASSERT
//		if(actTitle.trim().equals(expectedPage)) {
//			System.out.println(expectedPage+" Home page is verified");
//		}
//		else {
//			System.out.println(expectedPage+" Home page is not verified");
//		}
		
		Assert.assertEquals(actTitle, expectedPage);
		driver.close();
		System.out.println(mtd.getName() + "Test ends");
	}
	
	
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		
	System.out.println(mtd.getName() + "Test sarts");
		
		String expectedPage = "Home";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("Albin@123");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
		//HARD ASSERT
//		Assert.assertEquals(true, status);
		
		Assert.assertTrue(status);
//		if (status) {
//			System.out.println("logo is verified ");
//		}
//		else
//		{
//			System.out.println("logo is not verified");
//		}
		
		

		driver.close();
		System.out.println(mtd.getName() + " Test End");
	}
	
}
