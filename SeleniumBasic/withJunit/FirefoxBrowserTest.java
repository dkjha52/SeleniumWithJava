package withJunit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirefoxBrowserTest 
{
	public WebDriver driver;
	
	@Before
	public void setUp()
	{
		FirefoxOptions ffoptions = new FirefoxOptions();
		System.setProperty("webdriver.gecko.driver",
				"<Path of GeckoDriver>/geckodriver");
		ffoptions.setCapability("marionette", true);
		ffoptions.setCapability("acceptInsecureCerts", true);
		driver = new FirefoxDriver(ffoptions);
		driver.manage().window().maximize();
	}

	@Test
	public void testFirefox() throws InterruptedException
	{
		driver.get("http://opensource.demo.orangehrmlive.com");
		Thread.sleep(2000);
		WebElement elem=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		elem.sendKeys("Admin");
		Thread.sleep(300);
	    elem=driver.findElement(By.xpath("//input[@id='txtPassword']"));
		elem.sendKeys("admin");
		Thread.sleep(300);
	    elem=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		elem.click();
		Thread.sleep(3000);
	}
	@After
	public void tearDown()
	{
		driver.quit();
	}
}
