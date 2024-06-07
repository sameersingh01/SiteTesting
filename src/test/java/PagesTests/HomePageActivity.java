package PagesTests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import HelperPages.PropertiesReference;
import HelperPages.TestDataTL;
import PageFactory.HomePage;
import TestComponents.BasePage;

public class HomePageActivity extends BasePage {

	@Test
	public void search() throws Exception {
		propertiesReference = new PropertiesReference();
		TestDataTL testDataTL = ctd.get();
		driver = testDataTL.getDriver();
		HomePage homePage = new HomePage(driver);
		launchApplication();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage.searchBarField(propertiesReference.getValue("search_text"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    homePage.clickSearchBox();

}
}
