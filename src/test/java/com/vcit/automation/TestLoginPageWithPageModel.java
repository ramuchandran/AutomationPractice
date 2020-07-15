package com.vcit.automation;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vcit.automation.dataproviders.LoginData;
import com.vcit.automation.webpages.AccountPage;
import com.vcit.automation.webpages.HomePage;

public class TestLoginPageWithPageModel {

	WebDriver driver;
	
	@BeforeClass(groups = {"functest", "checkintest"})
	public void init() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(groups = {"functest"},dataProvider = "users",dataProviderClass = LoginData.class)
	public void testSignInLink(String username,String password) {
		HomePage home = new HomePage(driver);
	    home.clickSignInLink();
	    home.setEmail(username);
	    home.setPassword(password);
	    home.sleep(2);	
	    AccountPage page = new AccountPage(driver);
	    page.logout();
	}
	
	@Test(groups = {"functest", "checkintest"},dataProvider = "usersFromExcel",dataProviderClass = LoginData.class)
	public void testSignInWithUserFromExcel(String username,String password) {
		HomePage home = new HomePage(driver);
	    home.clickSignInLink();
	    home.setEmail(username);
	    home.setPassword(password);
	    home.sleep(2);	
	    AccountPage page = new AccountPage(driver);
	    page.logout();
	}
	
	@Test(groups = {"functest", "checkintest"},dataProvider = "usersFromTextFile",dataProviderClass = LoginData.class)
	public void testSignInWithUserFromText(String username,String password) {
		HomePage home = new HomePage(driver);
	    home.clickSignInLink();
	    home.setEmail(username);
	    home.setPassword(password);
	    home.sleep(2);	
	    AccountPage page = new AccountPage(driver);
//	    assertTrue(page.isUserLoggedIn(username));its not email it should be firstName LastName
	    page.logout();
	}
	
}
