package com.vcit.automation.webpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	private static String PAGE_URL="http://automationpractice.com";
	private WebDriver driver;
	
	   @FindBy(how =How.CSS,using ="body.my-account.hide-left-column.hide-right-column.lang_en:nth-child(2) div.header-container div.nav:nth-child(2) div.container div.row nav:nth-child(1) div.header_user_info:nth-child(1) a.account > span:nth-child(1)")
	   private WebElement loggedInUser;
	   
	   @FindBy(how = How.XPATH,using = "//a[@class='logout']")
	   private WebElement signOut;
	   

	   //Constructor
	   public AccountPage(WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   }
	   
	   public boolean isUserLoggedIn(String username) {
		   return username.equalsIgnoreCase(loggedInUser.getText());
	   }
	   
	   
	   public void logout() {
		   signOut.click();
	   }
	   
	 

}
