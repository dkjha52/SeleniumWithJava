package testNGSeleniumExtent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager 
{	 
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;
 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            //String workingDir = System.getProperty("user.dir");
            htmlReporter = new ExtentHtmlReporter("ExtentReportResults.html");
    		extent = new ExtentReports();
    		extent.attachReporter(htmlReporter);
    		extent.setSystemInfo("Selenium Java Version", "3.12.0");
    		extent.setSystemInfo("Environment", "Testing");
        }
        return extent;
    }
}