package com.groupexecution;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateOrgTest {	
	
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
	public void cerateOrgTest() {
		System.out.println("---execute create organization---");
	}
	@Test
	public void cerateOrgwithIndustry() {
		System.out.println("---execute create organization with industry---");
	}
	

	
}
