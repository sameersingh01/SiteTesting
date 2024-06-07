package PagesTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageFactory.LoginPage;
import HelperPages.PropertiesReference;
import HelperPages.TestDataTL;
import TestComponents.BasePage;

public class LoginPageActivity extends BasePage {
	
	@Test
	public void login() throws Exception {
		propertiesReference = new PropertiesReference();
		TestDataTL testDataTL = ctd.get();
		driver = testDataTL.getDriver();
		LoginPage lp = new LoginPage(driver);
		launchApplication();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parenthandle = driver.getWindowHandle();
		lp.click_Link();
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles)
		{
			if(!handle.equals(parenthandle))
			{
				driver.switchTo().window(handle);
				lp.click_registerButton();
				lp.click_loginButton();
				lp.useremailField(propertiesReference.getValue("user_email"));
				lp.passwordField(propertiesReference.getValue("password"));
				lp.final_loginButton();
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(parenthandle);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

}
