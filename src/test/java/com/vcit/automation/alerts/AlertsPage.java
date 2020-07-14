package com.vcit.automation.alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
	
	public static String PAGE_URL = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";
	WebElement element;
	
		@FindBy(how = How.XPATH, using = "//button[contains(text(),'Try it')]")
		private WebElement tryItButton;

	public AlertsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickTryIt() {
		tryItButton.click();
	}
}
