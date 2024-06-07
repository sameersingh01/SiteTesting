package PagesTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import HelperPages.PropertiesReference;
import HelperPages.TestDataTL;
import PageFactory.TopDealsPage;
import TestComponents.BasePage;

public class TopDealsClick extends BasePage {
	
	@Test
	public void topdeals() throws Exception {
		propertiesReference = new PropertiesReference();
		TestDataTL testDataTL = ctd.get();
		driver = testDataTL.getDriver();
		TopDealsPage topdeals = new TopDealsPage(driver);
		launchApplication();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parenthandle = driver.getWindowHandle();
		topdeals.clickTopDeals();
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles)
		{
			if(!handle.equals(parenthandle))
			{
				driver.switchTo().window(handle);
				topdeals.searchBarField(propertiesReference.getValue("name"));
				Select dropdown = new Select(topdeals.menu_button);
				dropdown.selectByVisibleText("10");
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(parenthandle);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		
		
	}

}
