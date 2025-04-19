package com.pac5.afterBaseclassCreationOrganization;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.objectrepositoryutility.CreatingNewOrganizationPage;
import com.crm.vtiger.objectrepositoryutility.HomePage;
import com.crm.vtiger.objectrepositoryutility.OrganizationPage;
import com.pac3.BaseClassCreation.BaseClass;

public class CreateOrganizationWithPhoneNumberTest extends BaseClass {

	@Test
	public void createOrgWithPhoneNum() throws EncryptedDocumentException, IOException {
		
	String orgName = eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
	String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
	
	HomePage hp = new HomePage(driver);
	hp.getOrgLink().click();
	
	OrganizationPage op = new OrganizationPage(driver);
	op.getCreateNewOrganizationBtn().click();
	
	CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	cnop.createOrgPhoneNumber(orgName, phoneNumber);

	
		
	//verify header orgname info expected result : EXPECTED RESULT
	
		String actualOrgName = cnop.getOrgNameTF().getText();
		if(actualOrgName.contains(orgName)) {
			System.out.println("Organization name verified ----- PASS");
		}else
		{
			System.out.println("organization name not verified ----- FAIL");
		}
		
	// validate phone number
	String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
	if(actPhoneNumber.equals(phoneNumber)) {
		System.out.println(phoneNumber +" Phone number is verified ------- pass");
	}
	else {
		System.out.println(phoneNumber + " industry not verified -------- fail");
	}
//	
//	
//	
//// step 4: logout from application
//	Actions act = new Actions(driver);
//
//	act.moveToElement(driver.findElement(By.xpath("//img [@src = 'themes/softed/images/user.PNG']"))).perform();
//	driver.findElement(By.linkText("Sign Out")).click();
//	
//	driver.quit();
//	
//	System.out.println("Execution successfully completed");
//	
	}
}
