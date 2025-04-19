package com.crm.vtiger.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath= "//img[@title='Create Contact...']")
	private WebElement plusicon;
	
	@FindBy(linkText = "Contacts")
	private WebElement cont_header;
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	// INITIALIZATION 
	WebDriver driver;
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void getPlusicon() {
		plusicon.click();
	}
	
	public String getCont_header() {
		return cont_header.getText();
	}
	
	
}
