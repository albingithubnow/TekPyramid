package com.pac5.afterBaseclassCreationOrganization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.objectrepositoryutility.CreatingNewOrganizationPage;
import com.crm.vtiger.objectrepositoryutility.HomePage;
import com.crm.vtiger.objectrepositoryutility.OrganizationInformationPage;
import com.crm.vtiger.objectrepositoryutility.OrganizationPage;
import com.pac3.BaseClassCreation.BaseClass;

public class CreateOrganization3in1 extends BaseClass {
	
	
		
@Test(groups = "smokeTest")
	
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
		
	
	
	//verify header orgname info expected result : EXPECTED RESULT
	
	OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	oip.getHeaderMsg().getText();
	String actOrgName =oip.getHeaderMsg().getText();
	if (actOrgName.contains(orgName)) {
		System.out.println("orgName is verified");
	}else 
		System.out.println("orgname is not verified");
		
	}

@Test(groups = "regressionTest")
public void createOrgWithIndustryType() throws Exception {

	String orgName = eLib.getDataFromExcel("org", 4, 2) +jLib.getRandomNumber();
	String industry = eLib.getDataFromExcel("org", 4, 3);
	String typw = eLib.getDataFromExcel("org", 4, 4);
	
	HomePage hp = new HomePage(driver);
	hp.getOrgLink().click();
	
	OrganizationPage op = new OrganizationPage(driver);
	op.getCreateNewOrganizationBtn().click();
	
	CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	cnop.createOrg(orgName, industry, typw);
	

// verify industry and type info
String industryName = driver.findElement(By.id("dtlview_Industry")).getText();
if(industryName.equals(industry)) {
	System.out.println(industry +" industry is verified ------- pass");
}
else {
	System.out.println(industry + " industry not verified -------- fail");
}


}

@Test(groups ="regressionTest")
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
	
}
	

}
