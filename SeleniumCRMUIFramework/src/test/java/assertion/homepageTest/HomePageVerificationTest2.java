package assertion.homepageTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageVerificationTest2 {

	@Test
	public void homePageTest(Method mtd) {

		System.out.println(mtd.getName() + "Test sarts");
		
		//converting hard assert into soft assert by creating an object of SoftAssert
		SoftAssert assertObj = new SoftAssert();

		System.out.println("Step-1");
		System.out.println("Step-2");
		
//		Assert.assertEquals("Home", "Home-page");
		assertObj.assertEquals("Home", "Home-page");
		
		System.out.println("Step-3");
//		Assert.assertEquals("Home-CRM", "Home-CRM");
		
		assertObj.assertEquals("Home-CRM", "Home-CRM");
		
		System.out.println("Step-4");
		assertObj.assertAll();
		
		System.out.println(mtd.getName() + "Test ends");
	}

	@Test
	public void verifyLogoHomePageTest(Method mtd) {

		System.out.println(mtd.getName() + "Test sarts");
		SoftAssert assertObj  = new SoftAssert();
		
		
		System.out.println("Step-1");
		System.out.println("Step-2");
		
//		Assert.assertTrue(true);
		assertObj.assertTrue(true);
		
		System.out.println("Step-3");
		System.out.println("Step-4");

		assertObj.assertAll();
		System.out.println(mtd.getName() + " Test End");
	}

}
