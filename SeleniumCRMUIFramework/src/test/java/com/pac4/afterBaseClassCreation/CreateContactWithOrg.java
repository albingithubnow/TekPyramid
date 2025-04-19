package com.pac4.afterBaseClassCreation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.objectrepositoryutility.ContactsPage;
import com.crm.vtiger.objectrepositoryutility.CreateNewContactPage;
import com.crm.vtiger.objectrepositoryutility.CreatingNewOrganizationPage;
import com.crm.vtiger.objectrepositoryutility.HomePage;
import com.crm.vtiger.objectrepositoryutility.OrganizationPage;
import com.pac3.BaseClassCreation.BaseClass;

public class CreateContactWithOrg extends BaseClass {
	@Test

	public void createContactWithOrgTest() throws Throwable {

		String contactLastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();

		// Step 1 : open the application

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 2 : navigate to organization
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrganizationBtn().click();

		// step 3: enter all the details and create new organization

		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.getOrgname_tf(orgName);
		cop.getsavebtn().click();

		// verify header message expected result

		String headerInfo = driver.findElement(By.xpath("//span[@class = 'dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " displayed in organization Info page ----- PASS");
		} else {
			System.out.println(orgName + " is not displayed in organization Info Page ----- FAIL");
		}

// step 7 : navigate to contact module
		hp.getContactLink().click();

		// create new contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getPlusicon();

// enter data into create contact page
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.getLastname_TF(contactLastName);

// click on lookup
		String pid = driver.getWindowHandle();
		cnc.getOrgplusicon();

		System.out.println("before search Textfield");
	// Switch to child window
//		Set<String> set = driver.getWindowHandles();
//		Iterator<String> it = set.iterator();
//		while (it.hasNext()) {
//			String Wid = it.next();
//			driver.switchTo().window(Wid);
//			String acturl = driver.getCurrentUrl();
//			if (acturl.contains("Accounts&action")) {
//				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgName);
//				Select s = new Select(driver.findElement(By.name("search_field")));
//				s.selectByVisibleText("Organization Name");
//				driver.findElement(By.name("search")).click();
//				driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
//			}
//		}
		
		wLib.switchToNewBrowser(driver);
		
//		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgName);
//		Select s = new Select(driver.findElement(By.name("search_field")));
//		s.selectByVisibleText("Organization Name");
//		driver.findElement(By.name("search")).click();
//		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		
		cnc.getorgSearchTF(orgName);
		wLib.select(cnc.getsearchfielddd(), "Organization Name");
		cnc.getsearchbtn();
		
		driver.switchTo().window(pid);

		//		// Switch to parent Window
//		wLib.switchToTabOnTitle(driver, url);

		cnc.getSavebtn();

		
		// verify the header phone number page
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(contactLastName)) {
			System.out.println(contactLastName + " information verified");
		} else {
			System.out.println(contactLastName + " information not verified");
		}

		// verify header orgname info expected result : EXPECTED RESULT

		String actualOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actualOrgName.trim().equals(orgName)) {
			System.out.println("Organization name verified ----- PASS");
		} else {
			System.out.println("organization name not verified ----- FAIL");
		}

//		driver.quit();
//
//		System.out.println("Execution successfully completed");

	}
}
