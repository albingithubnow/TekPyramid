package reportextent;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import extentreportBaseclass.BaseClass;

public class SampleReportTestAttachScreenshot

{
	public ExtentReports report;

	@BeforeSuite
	public void configBS() {

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

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");

		TakesScreenshot eDriver = (TakesScreenshot) driver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64); // extent report supports base64

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFCccc")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");

		}
		driver.close();

	}


}
