package HelperPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

	WebDriver driver;
	/*
	 * Only constructors can catch the variable , here driver variable you are
	 * sending from child (page class) to parent (componentBase)class
	 */
	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToAppear(By pageLocator) {
		WebDriverWait w = new WebDriverWait(driver , Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(pageLocator));
	}
}
