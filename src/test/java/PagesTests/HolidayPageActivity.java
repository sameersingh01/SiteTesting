package PagesTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import HelperPages.PropertiesReference;
import HelperPages.TestDataTL;
import PageFactory.HolidayPackagesPage;
import TestComponents.BasePage;

public class HolidayPageActivity extends BasePage {
	
	@Test
	public void holiday() throws Exception {
		propertiesReference = new PropertiesReference();
		TestDataTL testDataTL = ctd.get();
		driver = testDataTL.getDriver();
		HolidayPackagesPage holiday = new HolidayPackagesPage(driver);
		launchApplication();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parenthandle = driver.getWindowHandle();
		holiday.click_flight_booking_link();
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles)
		{
			if(!handle.equals(parenthandle))
			{
				driver.switchTo().window(handle);
				holiday.click_holidayPackage_link();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				holiday.destinationCity(propertiesReference.getValue("destinationcity"));
				holiday.departureCity(propertiesReference.getValue("departurecity"));
				holiday.returnCity(propertiesReference.getValue("returncity"));
				holiday.click_submit_button();
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(parenthandle);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		
		
	}

}
