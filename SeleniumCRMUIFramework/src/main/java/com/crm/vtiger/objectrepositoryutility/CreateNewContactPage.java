package com.crm.vtiger.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	@FindBy(xpath = "//span[text()='Creating New Contact']")
	private WebElement cnc_header;
	
	@FindBy (name = "lastname") 
	private WebElement lastname_TF;
	
	@FindBy (xpath = "(//img[@title='Select'])[1]")
	private WebElement orgplusicon;
	
	@FindBy (name = "support_start_date")
	private WebElement supportstartdate_tf;
	
	@FindBy(name = "support_end_date")
	private WebElement supportenddate_tf;
	
	@FindBy (xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	
	@FindBy (xpath = "//input[@name='search_text']")
	private WebElement orgSearchTF;
	
	@FindBy(name="search")
	private WebElement orgsearchbtn;
	
	@FindBy(name = "search_field")
	private WebElement searchfielddd;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startdate;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement enddate;
	
	
	//INITIALIZATION
	
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public String getCnc_header() {
		return cnc_header.getText();
	}
	
	public void getLastname_TF(String lastname) {
		lastname_TF.sendKeys(lastname);
		
	}

	public void getOrgplusicon() {
		 orgplusicon.click();
	}

	public void getSupportstartdate(String supportstartdate) {
		supportstartdate_tf.clear();
		supportstartdate_tf.sendKeys(supportstartdate);
	}
	
	public void getSupportenddate(String supportenddate) {
		supportenddate_tf.clear();
		supportenddate_tf.sendKeys(supportenddate);
	}
	
	public void getSavebtn() {
		savebtn.click();
	}
	
	public void getorgSearchTF(String orgname) {
		orgSearchTF.sendKeys(orgname);
	}
	
	public void getsearchbtn() {
		orgsearchbtn.click();
	}
	

	public WebElement getsearchfielddd() {
		return searchfielddd;
	}
	
	public WebElement getstartdate() {
		return startdate;
	}
	
	public WebElement getenddate() {
		return enddate;
	}
}
