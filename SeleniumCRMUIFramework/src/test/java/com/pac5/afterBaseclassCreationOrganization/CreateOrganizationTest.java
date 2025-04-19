package com.pac5.afterBaseclassCreationOrganization;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.vtiger.objectrepositoryutility.CreatingNewOrganizationPage;
import com.crm.vtiger.objectrepositoryutility.HomePage;
import com.crm.vtiger.objectrepositoryutility.OrganizationInformationPage;
import com.crm.vtiger.objectrepositoryutility.OrganizationPage;
import com.pac3.BaseClassCreation.BaseClass;

public class CreateOrganizationTest extends BaseClass{


	@Test
	
	public void createOrganization() throws EncryptedDocumentException, IOException {
		
		
		//read data from property file
	
		String orgName = eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
	
		// step : create organization button
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrganizationBtn().click();
		
		
		//step 3:  enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		
	
	//verify header message expected result
	
//	String headerInfo = driver.findElement(By.xpath("//span[@class = 'dvHeaderText']")).getText();
//	if(headerInfo.contains(orgName)) {
//		System.out.println(orgName + " displayed in organization Info page ----- PASS");
//	}else {
//		System.out.println(orgName + " is not displayed in organization Info Page ----- FAIL");
//	}
	
	//verify header orgname info expected result : EXPECTED RESULT
	
	OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	oip.getHeaderMsg().getText();
	String actOrgName =oip.getHeaderMsg().getText();
	if (actOrgName.contains(orgName)) {
		System.out.println("orgName is verified");
	}else 
		System.out.println("orgname is not verified");
		
	}
	
}
