package PagesTests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import HelperPages.PropertiesReference;
import HelperPages.TestDataTL;
import PageFactory.AddToCart;
import TestComponents.BasePage;

public class AddtoCartActivity extends BasePage {
	
	@Test
	public void addtocart() throws Exception {
		propertiesReference = new PropertiesReference();
		TestDataTL testDataTL = ctd.get();
		driver = testDataTL.getDriver();
		AddToCart atc = new AddToCart(driver);
		launchApplication();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		atc.click_addtocartButton();
		atc.click_addtocartIcon();
		atc.click_checkoutButton();
		atc.promocodeField(propertiesReference.getValue("promo_code"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		atc.click_applyButton();
		
		
	}


}
