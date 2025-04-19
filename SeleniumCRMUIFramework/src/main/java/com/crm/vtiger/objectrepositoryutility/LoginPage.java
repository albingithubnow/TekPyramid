package com.crm.vtiger.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumcrm.generic.webdriverutility.WebDriverUtility;

/**
 * @author Albin
 * 
 * Contains LoginPage elements & business Library like login
 * 
 */

public class LoginPage extends WebDriverUtility{
	
	WebDriver driver ;
	public LoginPage(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}

	@FindBy(name = "user_name")
	private WebElement userNameTF;
	
	@FindBy(name = "user_password")
	private WebElement passwordTF;
	
	@FindBy(id ="submitButton")
	private WebElement loginBtn;
	
	
	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * login to application based on uname, password, url arguements
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToApp(String url,String username,String password) {
		waitForPagetoLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		userNameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginBtn.click();
	}
	
}
