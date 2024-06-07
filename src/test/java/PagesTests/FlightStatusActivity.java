package PagesTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import HelperPages.PropertiesReference;
import HelperPages.TestDataTL;
import PageFactory.FlightStatusPage;
import TestComponents.BasePage;

public class FlightStatusActivity  extends BasePage {
	
	@Test
	public void flightStatus() throws Exception {
		propertiesReference = new PropertiesReference();
		TestDataTL testDataTL = ctd.get();
		driver = testDataTL.getDriver();
		FlightStatusPage fp = new FlightStatusPage(driver);
		launchApplication();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parenthandle = driver.getWindowHandle();
		fp.click_flight_booking_link();
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles)
		{
			if(!handle.equals(parenthandle))
			{
				driver.switchTo().window(handle);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				fp.click_flight_status_button();
				
				
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(parenthandle);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

}
