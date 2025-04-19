package com.pac4.afterBaseClassCreation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.objectrepositoryutility.ContactsPage;
import com.crm.vtiger.objectrepositoryutility.CreateNewContactPage;
import com.crm.vtiger.objectrepositoryutility.HomePage;
import com.pac3.BaseClassCreation.BaseClass;

public class CreateContactWIthSupportDate extends BaseClass {
	

	@Test
	public void createContactWithSupportDate() throws Exception {
		
		//read data from excel sheet
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		
		//navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		//create new contact button
		ContactsPage cp  = new ContactsPage(driver);
		cp.getPlusicon();
		
		//Enter lastName
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.getLastname_TF(lastName);
		
		
		//enter all the details and create new contact
		
		String startDate = jLib.getSystemDateYYYYDDMM();
		ccp.getSupportstartdate(startDate);
		
		String endDate = jLib.getRequiredDateYYYYDDMM();
		ccp.getSupportenddate(endDate);
		
	
		ccp.getSavebtn();
	
		
		
		// verify the start date and end date
		
				String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
				if(actStartDate.equals(startDate)) {
					System.out.println(startDate + " date verified");
				}else 
				{
					System.out.println(startDate + " date not verified");
				}
				
				String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
				if(actEndDate.equals(endDate)) {
					System.out.println(endDate + " date verified");
				}else 
				{
					System.out.println(endDate + " date not verified");
			}

	}
}


