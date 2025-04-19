package practiceConactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Exception {

		// read data from property file
		FileInputStream fis = new FileInputStream("./TestData/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		Random random = new Random();
		int randomInt = random.nextInt(1000);

		FileInputStream fis1 = new FileInputStream("./TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(7);
		String orgName = row.getCell(2).toString() + randomInt;
		String contactLastName = row.getCell(3).toString() + randomInt;
		wb.close();

		WebDriver driver = null;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		// Step 1 : open the application

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		// step 2 : navigate to organization
		WebElement organization = driver.findElement(By.linkText("Organizations"));
		organization.click();

		// step 3: create organization button

		WebElement addOrganization = driver.findElement(By.xpath("//img [@title ='Create Organization...']"));
		addOrganization.click();

		// step 4: enter all the details and create new organization

		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("assigned_user_id")).click();
		driver.findElement(By.xpath("(//input [@title = 'Save [Alt+S]'])[1]")).click();

		// verify header message expected result

		String headerInfo = driver.findElement(By.xpath("//span[@class = 'dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " displayed in organization Info page ----- PASS");
		} else {
			System.out.println(orgName + " is not displayed in organization Info Page ----- FAIL");
		}

// step 7 : navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();

		// create new contact button
		driver.findElement(By.xpath("//img[@title = \"Create Contact...\"]")).click();

		// enter data into create contact page
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("//input[@name = 'account_name']/following-sibling::img")).click();

		// Switch to child window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains("module=Accounts")) {
				break;
			}
		}

		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text() = '" + orgName + "']")).click();

		// Switch to parent Window

		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		while (it1.hasNext()) {
			String windowID = it1.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains("module=Contacts")) {
				break;
			}

		}

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		// verify the header phone number page
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(contactLastName)) {
			System.out.println(contactLastName + " information verified");
		} else {
			System.out.println(contactLastName + " information not verified");
		}

		// verify header orgname info expected result : EXPECTED RESULT

		String actualOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actualOrgName.trim().equals(orgName)) {
			System.out.println("Organization name verified ----- PASS");
		} else {
			System.out.println("organization name not verified ----- FAIL");
		}

		driver.quit();

		System.out.println("Execution successfully completed");

	}

}
