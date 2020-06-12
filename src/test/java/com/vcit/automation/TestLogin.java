package com.vcit.automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vcit.automation.keys.LoginKeys;

public class TestLogin {
	
	WebDriver wd;
	
	@BeforeClass(groups = {"functest", "checkintest"})
	public void init() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		wd= new ChromeDriver();
	}

	@Test(groups = {"functest"})
	public void testCustomerRegistrationWithInvalidEmail() throws Exception {
		wd.navigate().to("http://automationpractice.com/");
		wd.findElement(By.cssSelector(LoginKeys.signOnCss)).click();
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		wd.findElement(By.id("email_create")).sendKeys("test");
		wd.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
		WebElement element = wd.findElement(By.cssSelector(LoginKeys.invalidEmailCss));
		assertNotNull(element);
		assertEquals(element.getText(),"Invalid email address.");
	}
	
	@Test(groups = {"functest"})
	public void testCustomerRegistrationWithValidEmail() throws Exception {
		wd.navigate().to("http://automationpractice.com/");
		wd.findElement(By.cssSelector(LoginKeys.signOnCss)).click();
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		wd.findElement(By.id("email_create")).sendKeys("ramu123@gmail.com");
		wd.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement element = wd.findElement(By.cssSelector(LoginKeys.accountHeaderCss));
		assertNotNull(element);
		assertEquals(element.getText(), "CREATE AN ACCOUNT");
	}
	
	@AfterClass(groups = {"functest", "checkintest"})
	public void tearDown() {
		wd.quit();
	}
}
