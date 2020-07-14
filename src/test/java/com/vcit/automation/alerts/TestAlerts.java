package com.vcit.automation.alerts;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAlerts {
	WebDriver driver;
	
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testSimpleAlert() throws InterruptedException {
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		driver.switchTo().frame("iframeResult");
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Try it')]"));
		element.click();
		Alert alert= driver.switchTo().alert();
		String value = alert.getText();
		assertEquals(value, "I am an alert box!");
		alert.accept();
	}
	
	@Test
	public void testConfirmAlert() throws InterruptedException {
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.switchTo().frame("iframeResult");
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Try it')]"));
		element.click();
		Alert alert= driver.switchTo().alert();
		String value = alert.getText();
		assertEquals(value, "Press a button!");
		
		alert.accept();
		WebElement valElement =  driver.findElement(By.xpath("//p[@id='demo']"));
		assertEquals(valElement.getText(),"You pressed OK!");
		
		element = driver.findElement(By.xpath("//button[contains(text(),'Try it')]"));
		element.click();
		alert= driver.switchTo().alert();
		alert.dismiss();
		valElement =  driver.findElement(By.xpath("//p[@id='demo']"));
		assertEquals(valElement.getText(),"You pressed Cancel!");
		
	}
	
	@Test
	private void testPrompt() throws InterruptedException {
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Try it')]"));
		element.click();
		Alert alert= driver.switchTo().alert();
		alert.sendKeys("Ramu Chandan");;
		alert.accept();
		
		WebElement valElement =  driver.findElement(By.xpath("//p[@id='demo']"));
		assertEquals(valElement.getText(),"Hello Ramu Chandan! How are you today?");
		
		
	}
	
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	

}
