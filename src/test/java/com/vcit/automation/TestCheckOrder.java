package com.vcit.automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vcit.automation.keys.LoginKeys;

public class TestCheckOrder {

WebDriver driver;
	
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
	}


	@Test(groups = {"functest", "checkintest"})
	public void testCheckOrder() throws Exception {
		driver.navigate().to("http://automationpractice.com/");
		 driver.get("http://automationpractice.com/index.php");
		    driver.manage().window().setSize(new Dimension(852, 824));
		    driver.findElement(By.linkText("Sign in")).click();
		    driver.findElement(By.id("email")).click();
		    driver.findElement(By.id("email")).click();
		    {
		      WebElement element = driver.findElement(By.id("email"));
		      Actions builder = new Actions(driver);
		      builder.doubleClick(element).perform();
		    }
		    driver.findElement(By.id("email")).sendKeys("ramu.chandran@gmail.com");
		    driver.findElement(By.id("passwd")).click();
		    driver.findElement(By.id("passwd")).sendKeys("acha2519");
		    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
		    driver.findElement(By.cssSelector(".col-xs-12:nth-child(1) > .myaccount-link-list > li:nth-child(1) span")).click();
		    driver.findElement(By.linkText("KIYGDVJVC")).click();
		    driver.findElement(By.linkText("Sign out")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
