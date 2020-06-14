package com.vcit.automation;

import static org.testng.Assert.assertTrue;

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
	}

	@Test(groups = {"functest"},dataProvider = "users",dataProviderClass = LoginData.class)
	public void testSignInLink(String username,String password) {
		HomePage home = new HomePage(driver);
	    home.clickSignInLink();
	    home.setEmail(username);
	    home.setPassword(password);
	    home.sleep(2);	
	    AccountPage page = new AccountPage(driver);
	    assertTrue(page.isUserLoggedIn());
	}
}
