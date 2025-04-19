package com.pac4.afterBaseClassCreation;

import org.testng.annotations.Test;

import com.crm.vtiger.objectrepositoryutility.ContactInformationPage;
import com.crm.vtiger.objectrepositoryutility.ContactsPage;
import com.crm.vtiger.objectrepositoryutility.CreateNewContactPage;
import com.crm.vtiger.objectrepositoryutility.HomePage;
import com.pac3.BaseClassCreation.BaseClass;

public class CreateContact extends BaseClass{


	@Test
	public void createContactTest() throws Exception {

		// read test script data from excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// Navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getPlusicon();

		// enter all the details
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.getLastname_TF(lastName);

		ccp.getSavebtn();

		// verify the header phone number page
		ContactInformationPage cip = new ContactInformationPage(driver);

		String actLastName = cip.getcontactHeader();
		if (actLastName.contains(lastName)) {
			System.out.println(lastName + " information verified");
		} else {
			System.out.println(lastName + " information not verified");
		}

	}
}
