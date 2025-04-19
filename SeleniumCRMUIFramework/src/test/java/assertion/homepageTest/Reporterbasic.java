package assertion.homepageTest;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Reporterbasic {

	@Test
	public void HomePageTest (Method mtd) {
		Reporter.log(mtd.getName() + " Test Start");
	
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);
		Reporter.log(mtd.getName() + " Test End");
	}
	
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		Reporter.log(mtd.getName()+ " Test Start");
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);
		Reporter.log(mtd.getName() + " Test End");
		
	}
}
