package genericUtility;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports report;
	public static WebDriverUtility wbUtil;
	public static ExtentTest test;

	public FileUtility fUtil = new FileUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public JavaUtility jUtil = new JavaUtility();

	@BeforeSuite(alwaysRun = true)
	public void reportConfiguration() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_report/[REPORT] " + jUtil.getTimestamp() + ".html");
		report = new ExtentReports();
		report.attachReporter(spark);
	}

	@BeforeClass(alwaysRun = true)
	public void openBrowser() throws FileNotFoundException, IOException {
		driver = new ChromeDriver();
		wbUtil = new WebDriverUtility(driver);
		wbUtil.maximize();
		wbUtil.implicitWait(15);

		driver.get(fUtil.getDataFromProperties("url"));

		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home page is not diplayed as expected");

	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void reportBackup() {
		report.flush();
	}
}
