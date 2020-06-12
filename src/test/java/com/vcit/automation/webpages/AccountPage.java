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

public class AccountPage {
	
	private static String PAGE_URL="http://automationpractice.com";
	private WebDriver driver;
	
	   @FindBy(how =How.CSS,using ="body.my-account.hide-left-column.hide-right-column.lang_en:nth-child(2) div.header-container div.nav:nth-child(2) div.container div.row nav:nth-child(1) div.header_user_info:nth-child(1) a.account > span:nth-child(1)")
	   private WebElement loggedInUser;
	   

	   //Constructor
	   public AccountPage(WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	   }
	   
	   public boolean isUserLoggedIn() {
		   return "Ramu Chandran".equalsIgnoreCase(loggedInUser.getText());
	   }
	   
	   
	 

}
