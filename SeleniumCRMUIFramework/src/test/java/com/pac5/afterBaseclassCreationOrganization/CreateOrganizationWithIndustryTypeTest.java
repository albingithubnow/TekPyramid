package com.pac5.afterBaseclassCreationOrganization;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.objectrepositoryutility.CreatingNewOrganizationPage;
import com.crm.vtiger.objectrepositoryutility.HomePage;
import com.crm.vtiger.objectrepositoryutility.OrganizationPage;
import com.pac3.BaseClassCreation.BaseClass;

public class CreateOrganizationWithIndustryTypeTest extends BaseClass{

	@Test
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
}
