package testNGSeleniumExtent;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class BrowserTest extends TestListener
{
	
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
	@Test
	public void testinvalidLogin() throws InterruptedException
	{
		driver.get("http://opensource.demo.orangehrmlive.com");
		Thread.sleep(2000);
		WebElement elem=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		elem.sendKeys("Admin");
		Thread.sleep(300);
	    elem=driver.findElement(By.xpath("//input[@id='txtPassword']"));
		elem.sendKeys("admin123");
		Thread.sleep(300);
	    elem=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		elem.click();
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//a[@id='menu_dashboard_index']")).isDisplayed());
		Thread.sleep(300);
	}
	@Test
    public void testSkipped() {
        throw new SkipException("Skipping this test!");
    }
}
