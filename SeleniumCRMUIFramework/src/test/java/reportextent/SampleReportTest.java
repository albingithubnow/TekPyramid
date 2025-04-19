package reportextent;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import extentreportBaseclass.BaseClass;

public class SampleReportTest //extends BaseClass 

{
	public ExtentReports report;

	@BeforeSuite
	public void configBS() {
		// spark report config

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

	@AfterSuite
	public void configAS() {
		report.flush(); // take the back up of reports
	}

	@Test
	public void createcontactTest() {

		// by taking help of the test object we are creating the logs
		ExtentTest test = report.createTest("createcontactTest"); // creating a test

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}

		report.flush();

	}

	@Test
	public void createContactWithOrg() {

		ExtentTest test = report.createTest("createContactWithOrg"); // creating a test

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
	}

	@Test
	public void createContactWithPhoneNumber() {

		ExtentTest test = report.createTest("createContactWithPhoneNumber"); // creating a test

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
	}

}
