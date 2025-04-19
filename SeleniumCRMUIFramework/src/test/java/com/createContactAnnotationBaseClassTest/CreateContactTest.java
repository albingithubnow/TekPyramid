package com.createContactAnnotationBaseClassTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest  {	
	
	@BeforeSuite
	public void configBS() {
		System.out.println("----Execute before suite ----");
	}

	@AfterSuite
	public void configAS() {
		System.out.println("---Execute after suite---");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("---Execute before class---");
	}
	
	@BeforeMethod
	public void ConfigBM () {
		System.out.println("---execute before method---");
	}
	
	@Test
	public void cerateContactTest() {
		System.out.println("---execute create Contact---");
	}
	@Test
	public void cerateContactwithDate() {
		System.out.println("---execute create Contact with Date---");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("---Execute after method---");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("---Execute aAfter Class---");
	}

	
}
