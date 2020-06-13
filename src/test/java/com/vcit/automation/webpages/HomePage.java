package com.vcit.automation.webpages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vcit.automation.keys.LoginKeys;

public class HomePage {

	private static String PAGE_URL="http://automationpractice.com";
	private WebDriver driver;

//This is the new way to implement the Page Objects

	//Apply as Developer Button
	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	private WebElement signIn;

	@FindBy(how = How.ID, using = "email")
	private WebElement email;

	@FindBy(how = How.ID, using = "passwd")
	private WebElement passwd;

	@FindBy(how =How.CLASS_NAME,using ="page-heading")
	private WebElement myAccountHeading;
	//Constructor
	public HomePage(WebDriver driver){
		this.driver=driver;
		driver.get(PAGE_URL);
		//Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public void sleep(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}  

	public void clickSignInLink(){
		signIn.click();
		sleep(3);
	}

	public void setEmail(String userEmail) {
		email.sendKeys(userEmail);
	}

	public void setPassword(String pwd) {
		passwd.sendKeys(pwd);
		passwd.sendKeys(Keys.ENTER);
	}
}
