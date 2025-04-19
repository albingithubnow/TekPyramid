package practiceTestNG;

import org.testng.annotations.Test;

public class ContactTest {

	@Test()
	public void createcontactTest() {
		System.out.println(" create contact with ----->  HDFC");
	}
	
	@Test(dependsOnMethods = "createcontactTest")
	public void modifyContactTest() {
		System.out.println(" modify Contact HDFC --> ICICI");
	}

	@Test (dependsOnMethods = "modifyContactTest")
	public void deleteContactTest( ) {
		System.out.println(" delete contact -->ICICI");
	}
}
