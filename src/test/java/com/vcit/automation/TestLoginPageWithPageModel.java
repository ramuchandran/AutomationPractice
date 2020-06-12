package com.vcit.automation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vcit.automation.webpages.AccountPage;
import com.vcit.automation.webpages.HomePage;

public class TestLoginPageWithPageModel {

	WebDriver driver;
	
	@BeforeClass(groups = {"functest", "checkintest"})
	public void init() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
	}

	@Test(groups = {"functest"})
	public void testSignInLink() {
		HomePage home = new HomePage(driver);
	    home.clickSignInLink();
	    home.setEmail("ramu.chandran@gmail.com");
	    home.setPassword("acha2519");
	    home.sleep(2);	
	    AccountPage page = new AccountPage(driver);
	    assertTrue(page.isUserLoggedIn());
	}
}
