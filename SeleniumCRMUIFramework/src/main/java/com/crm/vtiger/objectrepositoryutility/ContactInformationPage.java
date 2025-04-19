package com.crm.vtiger.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {

// header
	
	@FindBy (className = "dvHeaderText")
	private WebElement contactHeader;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement verifylastname;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement verifyOrg;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement verifyStartdate;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement verifyEnddate;
	
	@FindBy(xpath = "//span[contains(text(),'Contact Information')]")
	private WebElement cip_header;

	//initialization
	WebDriver driver;
	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getVerifylastname() {
		return verifylastname.getText();
	}

	public String getVerifyOrg() {
		return verifyOrg.getText();
	}

	public String getVerifyStartdate() {
		return verifyStartdate.getText();
	}

	public String getVerifyEnddate() {
		return verifyEnddate.getText();
	}
	
	public String getcontactHeader() {
	return contactHeader.getText();
	}
	
	
	
	
	

}
