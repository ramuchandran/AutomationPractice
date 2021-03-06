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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vcit.automation.keys.LoginKeys;

public class TestLogin {
	
	WebDriver wd;
	
	@BeforeClass()
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
	
	@DataProvider(name = "users")
	public Object[][] userLoginDetails(){
		return new Object[][] {{"ramu.chandran@gmail.com"},{"ramu123@gmail.com"}};
	}
	
	@Test(groups = {"functest"}, dataProvider = "users")
	public void testCustomerRegistrationWithValidEmail(String user) throws Exception {
		wd.navigate().to("http://automationpractice.com/");
		wd.findElement(By.cssSelector(LoginKeys.signOnCss)).click();
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println(user);
		wd.findElement(By.id("email_create")).sendKeys(user);
		wd.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement element = wd.findElement(By.cssSelector(LoginKeys.accountHeaderCss));
		assertNotNull(element);
		assertEquals(element.getText(), "CREATE AN ACCOUNT");
	}
	
	@AfterClass()
	public void tearDown() {
		wd.quit();
	}
}
