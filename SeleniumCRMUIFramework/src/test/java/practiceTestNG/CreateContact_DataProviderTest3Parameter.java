package practiceTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProviderTest3Parameter {

	@Test(dataProvider = "getData")
	public void createContactTest (String firstName, String lastName, long phoneNumber) {
		
		System.out.println("FirstName : " +firstName + "Lastname : " +lastName + "  Number : " +phoneNumber);
		}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][3];
		
		objArr [0][0] = "Deepak";
		objArr [0][1] = "HR";
		objArr [0][2] = 987456321l;
		
		objArr [1][0] = "Sam";
		objArr [1][1] = "Sung";
		objArr [1][2] = 998877445l;
		 
		objArr [2][0] = "Jhon";
		objArr [2][1] = "Doe";
		objArr [2][2] = 987452136l;
		
		return objArr;
	}
	
}
