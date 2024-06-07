package TestComponents;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import HelperPages.Log4j;
import HelperPages.PropertiesReference;
import HelperPages.TestDataTL;
import HelperPages.WebdriverHelhper;

public class BasePage {
	public WebDriver driver;
	public PropertiesReference propertiesReference;
	protected ThreadLocal<TestDataTL> ctd = new ThreadLocal<TestDataTL>();

	@Parameters("platform")
	@BeforeMethod(alwaysRun = true)
	public void initializeDriver(String platform) throws Exception {
	  long threadID= Thread.currentThread().getId();
	  Log4j log4j = new Log4j();
	  Logger log = log4j.getLogger();
	  WebdriverHelhper webDriverHelper = new WebdriverHelhper();
	
	
	   if (platform.equalsIgnoreCase("local")) {
			 driver = webDriverHelper.getWebDriver();
			
		}
		
	   TestDataTL testDataTL = new TestDataTL(driver,threadID,log);
	   ctd.set(testDataTL);
	  
	}
	
	

	public void launchApplication() throws Exception {
		propertiesReference = new PropertiesReference();
		driver.get(propertiesReference.getValue("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		driver.close();
		
	}

	public String getScreenShotPath(String methodName, WebDriver driver) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshots\\" + methodName +".png";
		FileUtils.copyFile(ss, new File(destinationFile));
		return destinationFile;
	}

}
