package testNGSeleniumExtent;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class BaseTest 
{
	public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver getDriver() 
    {
        return driver;
    }
	 
    @BeforeMethod
    public void BeforeMethod()
    {
        System.out.println("I am in Before Method! Test is starting!");
        FirefoxOptions ffoptions = new FirefoxOptions();
		System.setProperty("webdriver.gecko.driver",
				"<Path of geckodriver>/geckodriver");
		ffoptions.setCapability("marionette", true);
		ffoptions.setCapability("acceptInsecureCerts", true);
		driver = new FirefoxDriver(ffoptions);
		driver.manage().window().maximize();
    }
 
    @AfterMethod
    public void AfterMethod()
    {
        System.out.println("I am in After Method! Test is ending!");
        driver.quit();
 
    }
}