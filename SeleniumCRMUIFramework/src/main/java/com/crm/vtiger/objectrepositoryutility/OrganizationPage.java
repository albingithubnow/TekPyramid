package com.crm.vtiger.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createNewOrganizationBtn;
	
	@FindBy(name ="search_text")
	private WebElement searctTF;
	
	
	@FindBy(name ="search_fieldt")
	private WebElement searchDD;
	
	@FindBy(name = "submit")
	private WebElement searchBtn;
	
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearctTF() {
		return searctTF;
	}

	public WebElement getSearctDD() {
		return searchDD;
	}
	

	public WebElement getCreateNewOrganizationBtn() {
		return createNewOrganizationBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	
	
}
