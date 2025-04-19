package practiceTestNG;

import org.testng.annotations.Test;

public class OrderTest {

	@Test(invocationCount = 10)
	public void createOrderTest() {
		System.out.println("Execute create order test ==> 123");
	}
	
	@Test (enabled = false )
	public void billingOrderTest() {
		System.out.println("Execute Billing order test ==>123");
	}
}
