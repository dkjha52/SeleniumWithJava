package withJunit;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentJunitTest 
{
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@Before
	public void setUp()
	{
		FirefoxOptions ffoptions = new FirefoxOptions();
		System.setProperty("webdriver.gecko.driver",
				"<path of geckodriver>/geckodriver");
		ffoptions.setCapability("marionette", true);
		ffoptions.setCapability("acceptInsecureCerts", true);
		driver = new FirefoxDriver(ffoptions);
		driver.manage().window().maximize();
		
		htmlReporter = new ExtentHtmlReporter("junit_extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Selenium Java Version", "3.12.0");
		extent.setSystemInfo("Environment", "Testing");
	}

	@Test
	public void testFirefox() throws InterruptedException, IOException
	{
		test=extent.createTest("Browser Intialization", "Verifying firefox browser");
		driver.get("http://opensource.demo.orangehrmlive.com");
		Thread.sleep(2000);
		test.log(Status.INFO, "Launch Application");
		WebElement elem=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		elem.sendKeys("Admin");
		Thread.sleep(300);
		test.log(Status.INFO, "Enter Username");
	    elem=driver.findElement(By.xpath("//input[@id='txtPassword']"));
		elem.sendKeys("admin");
		Thread.sleep(300);
		test.log(Status.INFO, "Enter Password");
	    elem=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		elem.click();
		Thread.sleep(3000);
		test.log(Status.INFO, "Click on Login button");
		// log with snapshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshot.png"));
		// test with snapshot
        test.addScreenCaptureFromPath("junitscreenshot.png");
		Thread.sleep(3000);
	}
	@After
	public void tearDown()
	{
		driver.quit();
		extent.flush();
	}
}
