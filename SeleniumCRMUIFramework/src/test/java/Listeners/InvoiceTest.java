package Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclassListeners.BaseClassListeners;


@Listeners(com.seleniumcrm.listenerutility.ListenerImplClass.class)

public class InvoiceTest extends BaseClassListeners {

	@Test
	public void createInvoice() {
		System.out.println("execute create invoice");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "login");
		
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	@Test
	
	public void createInvoicewithContactTest() {
		System.out.println("execute createInvoice with contact");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
