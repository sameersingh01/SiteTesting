package PagesTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;


import HelperPages.PropertiesReference;
import HelperPages.TestDataTL;
import PageFactory.FlightBookingPage;
import TestComponents.BasePage;

public class FlightBookingActivity extends BasePage {
	
	@Test
	public void flightBook() throws Exception {
		propertiesReference = new PropertiesReference();
		TestDataTL testDataTL = ctd.get();
		driver = testDataTL.getDriver();
		FlightBookingPage fbp = new FlightBookingPage(driver);
		launchApplication();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parenthandle = driver.getWindowHandle();
		fbp.click_flight_booking_link();
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles)
		{
			if(!handle.equals(parenthandle))
			{
				driver.switchTo().window(handle);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				fbp.click_roundtrip_button();
				fbp.click_departure();
				fbp.click_departure_city();
				fbp.click_arrival_city();
				fbp.click_depart_date();
				fbp.click_return_date();
				fbp.click_my_returnDate();
				fbp.click_searchFlight();
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(parenthandle);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

}
