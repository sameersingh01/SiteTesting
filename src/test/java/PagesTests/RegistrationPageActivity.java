package PagesTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import HelperPages.PropertiesReference;
import HelperPages.TestDataTL;
import PageFactory.RegistrationPage;
import TestComponents.BasePage;

public class RegistrationPageActivity extends BasePage {

	@Test
	public void registration() throws Exception {
		propertiesReference = new PropertiesReference();
		TestDataTL testDataTL = ctd.get();
		driver = testDataTL.getDriver();
		RegistrationPage rp = new RegistrationPage(driver);
		launchApplication();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parenthandle = driver.getWindowHandle();
		rp.click_Link();
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles)
		{
			if(!handle.equals(parenthandle))
			{
				driver.switchTo().window(handle);
				rp.click_registerButton();
				rp.click_emailButton();
				rp.usernameField(propertiesReference.getValue("user_name"));
				rp.useremailField(propertiesReference.getValue("user_email"));
				rp.passwordField(propertiesReference.getValue("password"));
				rp.click_signupButton();
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(parenthandle);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

}
