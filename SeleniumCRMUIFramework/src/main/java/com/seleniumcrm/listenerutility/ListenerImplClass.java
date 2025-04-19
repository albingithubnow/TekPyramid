package com.seleniumcrm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.seleniumcrm.generic.webdriverutility.UtilityClassObject;

import baseclassListeners.BaseClassListeners;
import extentreportBaseclass.BaseClass;

public class ListenerImplClass implements ITestListener, ISuiteListener {

	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		System.out.println("Report configuration");
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Environment information & create test
		report = new ExtentReports();
		report.attachReporter(spark);

		// adding system information
		report.setSystemInfo("OS", "WWindows-11");
		report.setSystemInfo("BROWSER", "CHROME-5");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		System.out.println("Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("----------"+ result.getMethod().getMethodName()+"------START------");
		
		test = report.createTest(result.getMethod().getMethodName()); // creating a test
		
		UtilityClassObject.setTest(test);
		
		test.log(Status.INFO, result.getMethod().getMethodName()+" ----- Started -----");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, result.getMethod().getMethodName()+" ------ENDED------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		String testName = result.getMethod().getMethodName();
		
//		TakesScreenshot ts = (TakesScreenshot) (BaseClassListeners.sdriver);
//		File src = ts.getScreenshotAs(OutputType.FILE);
		
		TakesScreenshot eDriver = (TakesScreenshot) BaseClassListeners.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64); // extent report supports base64

		String time = 	new Date().toString().replace(" ", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(filePath, testName+ " " +time);
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+" ------FAILED------");
		
//		File dest = new File("./Screenshot/"+testName+""+time+".png");
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		
	}

}
