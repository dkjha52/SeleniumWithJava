package withJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariBrowserTest 
{
	public static WebDriver driver;

	public static void main(String args[]) throws InterruptedException 
	{
		SafariOptions safoption = new SafariOptions();
		safoption.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new SafariDriver(safoption);
		driver.manage().window().maximize();
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
		driver.quit();
	}
}
