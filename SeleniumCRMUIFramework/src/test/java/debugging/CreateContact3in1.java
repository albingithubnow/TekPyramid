package debugging;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.vtiger.objectrepositoryutility.ContactInformationPage;
import com.crm.vtiger.objectrepositoryutility.ContactsPage;
import com.crm.vtiger.objectrepositoryutility.CreateNewContactPage;
import com.crm.vtiger.objectrepositoryutility.CreatingNewOrganizationPage;
import com.crm.vtiger.objectrepositoryutility.HomePage;
import com.crm.vtiger.objectrepositoryutility.OrganizationPage;
import com.pac3.BaseClassCreation.BaseClass;
import com.seleniumcrm.generic.webdriverutility.UtilityClassObject;
import com.seleniumcrm.listenerutility.ListenerImplClass;

@Listeners(com.seleniumcrm.listenerutility.ListenerImplClass.class)
public class CreateContact3in1 extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest"})
	public void createContactTest() throws Exception {

		
		UtilityClassObject.getTest().log(Status.INFO,"read data form excel");
		
		// read test script data from excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// Navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to contact page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// click on create contact button
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create new contact page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getPlusicon();

		// enter all the details
		UtilityClassObject.getTest().log(Status.INFO,"create new contact");

		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.getLastname_TF(lastName);

		ccp.getSavebtn();

		UtilityClassObject.getTest().log(Status.INFO,"create contact");

		// verify the header phone number page
		ContactInformationPage cip = new ContactInformationPage(driver);

		String actLastName = cip.getcontactHeader();
		if (actLastName.contains(lastName)) {
			System.out.println(lastName + " information verified");
		} else {
			System.out.println(lastName + " information not verified");
		}
	}
		@Test (groups ="regressionTest")

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
			
		// Switch to child window
			
			wLib.switchToNewBrowser(driver);
			
			cnc.getorgSearchTF(orgName);
			wLib.select(cnc.getsearchfielddd(), "Organization Name");
			cnc.getsearchbtn();
			
			driver.switchTo().window(pid);

	
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
		}

			@Test(groups ="regressionTest")
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
