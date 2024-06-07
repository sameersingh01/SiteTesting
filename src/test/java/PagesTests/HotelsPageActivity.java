package PagesTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import HelperPages.PropertiesReference;
import HelperPages.TestDataTL;
import PageFactory.HotelsCheckPage;
import TestComponents.BasePage;

public class HotelsPageActivity extends BasePage {
	
	@Test
	public void hotels() throws Exception {
		propertiesReference = new PropertiesReference();
		TestDataTL testDataTL = ctd.get();
		driver = testDataTL.getDriver();
		HotelsCheckPage hp = new HotelsCheckPage(driver);
		launchApplication();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parenthandle = driver.getWindowHandle();
		hp.click_flight_booking_link();
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles)
		{
			if(!handle.equals(parenthandle))
			{
				driver.switchTo().window(handle);
				hp.click_hotels_link();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				hp.destinationCityField(propertiesReference.getValue("destinationcity"));
				hp.click_search_button();
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(parenthandle);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

}
