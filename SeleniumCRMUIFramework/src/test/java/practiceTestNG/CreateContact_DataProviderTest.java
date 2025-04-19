package practiceTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProviderTest {

	@Test(dataProvider = "getData")
	public void createContactTest (String firstName, String lastName) {
		
		System.out.println("FirstName : " +firstName+ "Lastname : " +lastName);
		}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][2];
		
		objArr [0][0] = "Deepak";
		objArr [0][1] = "HR";
		
		objArr [1][0] = "Sam";
		objArr [1][1] = "Sung";
		 
		objArr [2][0] = "Jhon";
		objArr [2][1] = "Doe";
		
		return objArr;
	}
	
}
