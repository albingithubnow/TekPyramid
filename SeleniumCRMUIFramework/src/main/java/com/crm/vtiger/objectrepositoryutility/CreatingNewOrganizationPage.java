package com.crm.vtiger.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

	
	public CreatingNewOrganizationPage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameTF;
	
	@FindBy(xpath = "//input[@title = \"Save [Alt+S]\"]")
	private WebElement saveBtn;

	@FindBy (name = "industry")
	private WebElement industryDD;
	@FindBy(xpath="//span[text()='Creating New Organization']")
	private WebElement cno_header;
	
	@FindBy(name = "accountname")
	private WebElement orgname_tf;
	
	@FindBy(id = "phone")
	private WebElement phone_tf;
	
	@FindBy(name = "industry")
	private WebElement idustry_drpdn;
	
	@FindBy(name = "accounttype")
	private WebElement type_drpdn;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;

	
	// INITIALIZATION 
	
	WebDriver driver;
	public void CreatingNewOrganizaationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String getCno_header() {
		return cno_header.getText();
	}

	public void getOrgname_tf(String orgname) {
		orgname_tf.sendKeys(orgname);
	}

	public void getPhone_tf(String phno) {
		phone_tf.sendKeys(phno);
	}

	public WebElement getIdustry_drpdn() {
		return idustry_drpdn;
	}

	public WebElement getType_drpdn() {
		return type_drpdn;
	}

	public WebElement getsavebtn() {
		return savebtn;
	}
	
	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getsaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String orgName) {
		orgNameTF.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrgPhoneNumber(String orgName, String phno) {
		orgNameTF.sendKeys(orgName);
		phone_tf.sendKeys(phno);
		
	}
	public void createOrg (String orgName, String industry,String phno) {
		orgNameTF.sendKeys(orgName);
	
		Select sel = new Select(industryDD);
		sel.selectByVisibleText(industry);
		
		phone_tf.sendKeys(phno);
		saveBtn.click();
	}
}
