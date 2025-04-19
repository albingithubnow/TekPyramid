package Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclassListeners.BaseClassListeners;


@Listeners(com.seleniumcrm.listenerutility.ListenerImplClass.class)

public class InvoiceTestRetry extends BaseClassListeners {

	@Test(retryAnalyzer = com.seleniumcrm.listenerutility.RetryListenerImpl.class)
	public void activateSim() {
		System.out.println("execute create invoice");
		Assert.assertEquals("", "login");
		
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	
}
