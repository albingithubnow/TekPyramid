package practiceConactTest;

import org.testng.annotations.Test;

import com.crm.vtiger.objectrepositoryutility.LoginPage;
import com.pac3.BaseClassCreation.BaseClass;

/**
 * Test class for good practice
 * @author Albin
 */
public class GoodPracticeTest extends BaseClass {

	@Test
	public void searchContactTet() {
		
		/*step 1: login to app*/
		LoginPage lp =new LoginPage(driver);
		lp.loginToApp("url", "username", "password");
	}
}
