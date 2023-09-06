package com.raghib.selenium;

/**
 * Reference:-
 * https://www.youtube.com/watch?v=wruARY-vsZQ
 * https://stackoverflow.com/questions/75499409/how-to-close-the-promotion-popup-in-makemytrip-com-using-selenium-webdriver
 * https://stackoverflow.com/questions/33199740/webdriver-remove-element-from-page
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownAutoSuggestionExample extends BaseClass {
	
	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";
	
	public static String url = "https://www.makemytrip.com";
	
	public static void main(String[] args) throws InterruptedException {
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);
	
		WebDriverWait frameWait = new WebDriverWait(driver, Duration.ofSeconds(50));
		frameWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@title, 'notification-frame')]")));
		frameWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='wewidgeticon we_close']"))).click();
		
        driver.switchTo().defaultContent();
        
        /* create a reference for the JavascriptExecutor interface and type cast the driver object */
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("return document.getElementsByClassName('imageSlideContainer')[0].remove();");
        
        WebDriverWait fromWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement fromElement = driver.findElement(By.xpath("//input[@id='fromCity']"));
        fromWait.until(ExpectedConditions.
        		elementToBeClickable(fromElement));
        fromElement.sendKeys(Keys.ENTER);

		WebElement sourceLocation = driver.findElement(By.xpath("//div[@role='combobox']//input[@type='text']"));

		try {
			Thread.sleep(3000);
			sourceLocation.sendKeys("GAY");
			Thread.sleep(2000);
			sourceLocation.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			sourceLocation.sendKeys(Keys.ENTER);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(Keys.ENTER);
		WebElement destinationLocation = driver
				.findElement(By.xpath("//div[@role='combobox']//input[@placeholder='To']"));

		try {
			Thread.sleep(3000);
			destinationLocation.sendKeys("BLR");

			int count = 1;
			while (count < 3) {
				Thread.sleep(3000);
				destinationLocation.sendKeys(Keys.ARROW_DOWN);
				count++;
			}

			Thread.sleep(3000);
			destinationLocation.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseClass.quitDriver();	
	}
}
